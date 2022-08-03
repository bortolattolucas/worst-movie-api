package com.goldenraspberryawards.worstmovieapi.repositories;

import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    @Query("SELECT DISTINCT obj FROM Producer obj " +
            "WHERE " +
            "LOWER(obj.name) = LOWER(:name)")
    Producer findByName(String name);

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM (SELECT r1.nomination_year AS first_year, " +
                    "             (SELECT nomination_year " +
                    "              FROM award r2 " +
                    "                       INNER JOIN tb_award_producer tb ON tb.award_id = r2.id " +
                    "              WHERE r2.nomination_year > r1.nomination_year " +
                    "                AND r1.winner IS TRUE " +
                    "                AND r2.winner IS TRUE " +
                    "                AND nomination_year IS NOT NULL " +
                    "                AND tb.producer_id = p.id " +
                    "              ORDER BY nomination_year ASC " +
                    "              limit 1)            AS last_year, " +
                    "             p.id               AS producer_id " +
                    "      FROM award AS r1 " +
                    "               INNER JOIN tb_award_producer tb ON tb.award_id = r1.id " +
                    "               INNER JOIN producer p ON p.id = tb.producer_id " +
                    "      ORDER BY r1.nomination_year) " +
                    "         AS r " +
                    "GROUP BY r.first_year, r.last_year, r.producer_id " +
                    "HAVING r.last_year - r.first_year = " +
                    "       (SELECT MAX(r.last_year - r.first_year) " +
                    "        FROM (SELECT r1.nomination_year AS first_year, " +
                    "                     (SELECT nomination_year " +
                    "                      FROM award r2 " +
                    "                               INNER JOIN tb_award_producer tb ON tb.award_id = r2.id " +
                    "                      WHERE r2.nomination_year > r1.nomination_year " +
                    "                        AND r1.winner IS TRUE " +
                    "                        AND r2.winner IS TRUE " +
                    "                        AND nomination_year IS NOT NULL " +
                    "                        AND tb.producer_id = p.id " +
                    "                      ORDER BY nomination_year ASC " +
                    "                      limit 1)            AS last_year, " +
                    "                     p.id               AS producer_id " +
                    "              FROM award AS r1 " +
                    "                       INNER JOIN tb_award_producer tb ON tb.award_id = r1.id " +
                    "                       INNER JOIN producer p ON p.id = tb.producer_id " +
                    "              ORDER BY r1.nomination_year) " +
                    "                 AS r);")
    Object[] findMaxIntervals();

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM (SELECT r1.nomination_year AS first_year, " +
                    "             (SELECT nomination_year " +
                    "              FROM award r2 " +
                    "                       INNER JOIN tb_award_producer tb ON tb.award_id = r2.id " +
                    "              WHERE r2.nomination_year > r1.nomination_year " +
                    "                AND r1.winner IS TRUE " +
                    "                AND r2.winner IS TRUE " +
                    "                AND nomination_year IS NOT NULL " +
                    "                AND tb.producer_id = p.id " +
                    "              ORDER BY nomination_year ASC " +
                    "              limit 1)            AS last_year, " +
                    "             p.id               AS producer_id " +
                    "      FROM award AS r1 " +
                    "               INNER JOIN tb_award_producer tb ON tb.award_id = r1.id " +
                    "               INNER JOIN producer p ON p.id = tb.producer_id " +
                    "      ORDER BY r1.nomination_year) " +
                    "         AS r " +
                    "GROUP BY r.first_year, r.last_year, r.producer_id " +
                    "HAVING r.last_year - r.first_year = " +
                    "       (SELECT MIN(r.last_year - r.first_year) " +
                    "        FROM (SELECT r1.nomination_year AS first_year, " +
                    "                     (SELECT nomination_year " +
                    "                      FROM award r2 " +
                    "                               INNER JOIN tb_award_producer tb ON tb.award_id = r2.id " +
                    "                      WHERE r2.nomination_year > r1.nomination_year " +
                    "                        AND r1.winner IS TRUE " +
                    "                        AND r2.winner IS TRUE " +
                    "                        AND nomination_year IS NOT NULL " +
                    "                        AND tb.producer_id = p.id " +
                    "                      ORDER BY nomination_year ASC " +
                    "                      limit 1)            AS last_year, " +
                    "                     p.id               AS producer_id " +
                    "              FROM award AS r1 " +
                    "                       INNER JOIN tb_award_producer tb ON tb.award_id = r1.id " +
                    "                       INNER JOIN producer p ON p.id = tb.producer_id " +
                    "              ORDER BY r1.nomination_year) " +
                    "                 AS r);")
    Object[] findMinIntervals();
}
