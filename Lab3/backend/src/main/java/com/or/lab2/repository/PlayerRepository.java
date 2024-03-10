package com.or.lab2.repository;

import com.or.lab2.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findAllByHeight(Integer visina);
    List<Player> findAllByWeight(Integer tezina);
    List<Player> findAllByJerseyNumber(Integer brojdresa);
    List<Player> findAllByPointsPerGame(Double poenipoutakmici);
    List<Player> findAllByFirstName(String ime);
    List<Player> findAllByLastName(String prezime);
    List<Player> findAllByDateOfBirth(LocalDate datumrodjenja);
    List<Player> findAllByPosition(String pozicija);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE pobjede = %:searchText%", nativeQuery = true)
    List<Player> findAllByWins(@Param("searchText") Integer searchText);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE porazi = %:searchText%", nativeQuery = true)
    List<Player> findAllByLosses(@Param("searchText") Integer searchText);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE grad LIKE %:searchText%", nativeQuery = true)
    List<Player> findAllByCity(@Param("searchText")String searchText);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE nazivtima LIKE %:searchText%", nativeQuery = true)
    List<Player> findAllByTeamName(@Param("searchText") String searchText);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE visina = %:searchText% OR tezina = %:searchText% OR brojdresa = %:searchText% OR poenipoutakmici = %:searchText% OR porazi = %:searchText% OR pobjede = %:searchText%", nativeQuery = true)
    List<Player> findByAllNumber(@Param("searchText") Integer searchText);

    @Query(value = "SELECT * FROM igraci NATURAL JOIN timovi WHERE ime LIKE %:searchText% OR prezime LIKE %:searchText% OR pozicija LIKE %:searchText% OR nazivtima LIKE %:searchText% OR grad LIKE %:searchText%", nativeQuery = true)
    List<Player> findAllByAlpha(@Param("searchText") String searchText);



}
