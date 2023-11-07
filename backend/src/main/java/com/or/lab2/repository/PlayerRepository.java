package com.or.lab2.repository;

import com.or.lab2.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findAllByHeight(Integer visina);
    List<Player> findAllByWeight(Integer tezina);
    List<Player> findAllByJerseyNumber(Integer brojdresa);
    List<Player> findAllByPointsPerGame(Double poenipoutakmici);
    List<Player> findAllByFirstName(String ime);
    List<Player> findAllByLastName(String prezime);
    List<Player> findAllByDateOfBirth(Date datumrodjenja);
    List<Player> findAllByPosition(String pozicija);


    @Query(value = "SELECT * FROM igraci WHERE visina LIKE %:searchText% OR tezina LIKE %:searchText% OR brojdresa LIKE %:searchText% OR poenipoutakmici LIKE %:searchText%", nativeQuery = true)
    List<Player> findByAllNumber(@Param("searchText") String searchText);

    @Query(value = "SELECT * FROM igraci WHERE ime LIKE %:searchText% OR prezime LIKE %:searchText% OR pozicija LIKE %:searchText%", nativeQuery = true)
    List<Player> findAllByAlpha(@Param("searchText") String searchText);
}
