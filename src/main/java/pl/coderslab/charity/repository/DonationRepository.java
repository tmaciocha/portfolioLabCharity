package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

    //@Query(value = "select SUM(quantity)  from donation where quantity>0",nativeQuery = true)
    @Query(value = "select sum(b.quantity) from Donation b where b.quantity>0")//jpql
    Integer quantitySum();


  //  @Query(value = "select COUNT(*)  from donation",nativeQuery = true)
    @Query(value = "select count(b) from Donation b")//jpql
    Integer countAll();


}
