package com.intellidesk.repo;

import com.intellidesk.entity.Priority;
import com.intellidesk.entity.Status;
import com.intellidesk.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE tbl_tickets
    SET
        summary = COALESCE(:summary, summary),
        priority = COALESCE(:priority, priority),
        status = COALESCE(:status, status),
        updated_at = CURRENT_TIMESTAMP
    WHERE id = :id
    """, nativeQuery = true)
    int updateTicket(
            @Param("id") Long id,
            @Param("summary") String summary,
            @Param("priority") String priority,
            @Param("status") String status
    );
}
