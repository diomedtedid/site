package org.proskura.services;

import org.proskura.dao.MessageDAO;
import org.proskura.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 25.11.2017.
 */

@Service
public class MessageService {

    @Autowired
    private final MessageDAO messageDAO;


    public <S extends Message> S save (S entity) {
        return messageDAO.save(entity);
    }
}
