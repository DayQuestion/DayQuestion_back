package site.dayquestion.Follow.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import site.dayquestion.Enum.Status;
import site.dayquestion.domain.Follow;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Primary
public class FollowRepositoryImpl implements FollowRepository {
    private final EntityManager em;

    @Override
    public Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId) {
        try {
            String query = "select f " +
                    "from Follow f " +
                    "where f.follower.id = :followerId and f.following.id = :followingId and f.status <> :statusDeleted";
            Object foundFollow = em.createQuery(query)
                    .setParameter("followerId", followerId)
                    .setParameter("followingId", followingId)
                    .setParameter("statusDeleted", Status.DELETED)
                    .getSingleResult();

            return (Follow) foundFollow;
        } catch (NoResultException ne) {
            return null;
        }
    }

    @Override
    public List<Follow> findAllByFollowerId(Long followerId) {
        String query = "select f " +
                    "from Follow f " +
                    "where f.follower.id = :followerId and f.status <> :statusDeleted";
        return em.createQuery(query)
                    .setParameter("followerId", followerId)
                    .setParameter("statusDeleted", Status.DELETED)
                    .getResultList();
    }

    @Override
    public List<Follow> findAllByFollowingId(Long followingId) {
        String query = "select f " +
                "from Follow f " +
                "where f.following.id = :followingId and f.status <> :statusDeleted";
        return em.createQuery(query)
                .setParameter("followingId", followingId)
                .setParameter("statusDeleted", Status.DELETED)
                .getResultList();
    }

    @Override
    public Long save(Follow follow) {
        em.persist(follow);
        em.flush();

        return follow.getId();

    }
}

