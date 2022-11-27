package online.ij3rry.my_chess.repositories;

import online.ij3rry.my_chess.dao.RoomDAO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface RoomRepository extends ReactiveMongoRepository<RoomDAO, UUID> {
    Flux<RoomDAO> findTopByOrderByCreatedDesc();

    @Tailable
    @Query("{'id':?0}")
     Flux<RoomDAO> findByRoomId(UUID roomId);
}
