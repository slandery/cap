package com.tts.cap.repository;

import com.tts.cap.model.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber, Long> {

}
