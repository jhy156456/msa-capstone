package hwmsacapstone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hwmsacapstone.config.kafka.KafkaProcessor;
import hwmsacapstone.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkRegistered_SendRegisterBookmark(
        @Payload BookmarkRegistered bookmarkRegistered
    ) {
        if (!bookmarkRegistered.validate()) return;
        BookmarkRegistered event = bookmarkRegistered;
        System.out.println(
            "\n\n##### listener SendRegisterBookmark : " +
            bookmarkRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Message.sendRegisterBookmark(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookmarkCanceled_SendCancelBookmark(
        @Payload BookmarkCanceled bookmarkCanceled
    ) {
        if (!bookmarkCanceled.validate()) return;
        BookmarkCanceled event = bookmarkCanceled;
        System.out.println(
            "\n\n##### listener SendCancelBookmark : " +
            bookmarkCanceled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Message.sendCancelBookmark(event);
    }
    // keep

}
