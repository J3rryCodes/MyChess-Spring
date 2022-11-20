package online.ij3rry.my_chess.repositories;

import online.ij3rry.my_chess.dao.PlayerDAO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<PlayerDAO, UUID> {

    public Mono<PlayerDAO> findByName(String name);
}
