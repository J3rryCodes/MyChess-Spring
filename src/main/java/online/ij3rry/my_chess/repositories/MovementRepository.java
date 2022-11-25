package online.ij3rry.my_chess.repositories;

import online.ij3rry.my_chess.dao.MovementDAO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface MovementRepository extends ReactiveMongoRepository<MovementDAO, UUID> {
}
