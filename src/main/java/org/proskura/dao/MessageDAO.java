package org.proskura.dao;

import org.proskura.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 25.11.2017.
 */
public interface MessageDAO extends JpaRepository<Message, Long> {
}
