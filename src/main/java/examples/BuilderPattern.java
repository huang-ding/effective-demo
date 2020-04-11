package examples;

import examples.BuilderPattern.AppMessage.Builder;
import java.util.UUID;

/**
 * builder模式
 * <p>使用builder模式改进AppMessages<p/>
 *
 * @author huangding
 * @date 2020/4/1 21:32
 */
public class BuilderPattern {


    public static void main(String[] args) {
        AppMessage build = new Builder(UUID.randomUUID().toString(), "admin", 1, "nmd", "nmd")
            .build();

    }

    public static class AppMessage {

        private final String messageId;

        private final String sendId;

        private final Integer boxType;

        private final String title;

        private final String content;

        private final String imageUrl;

        private final Long sendTime;

        private final int expiryDay;

        private final Object extData;

        private final Boolean ofPush;


        public static class Builder {

            private final String messageId;

            private final String sendId;

            private final Integer boxType;

            private final String title;

            private final String content;


            private String imageUrl = "";

            private Long sendTime = System.currentTimeMillis();

            private int expiryDay = 0;

            private Object extData = null;

            private Boolean ofPush = false;

            public Builder(String messageId, String sendId, Integer boxType, String title,
                String content) {
                this.messageId = messageId;
                this.sendId = sendId;
                this.boxType = boxType;
                this.title = title;
                this.content = content;
            }

            public Builder imageUrl(String val) {
                imageUrl = val;
                return this;
            }

            public Builder sendTime(Long val) {
                sendTime = val;
                return this;
            }

            public Builder expiryDay(int val) {
                expiryDay = val;
                return this;
            }

            public Builder extData(Object val) {
                extData = val;
                return this;
            }

            public Builder ofPush(Boolean val) {
                ofPush = val;
                return this;
            }

            public AppMessage build() {
                return new AppMessage(this);
            }
        }

        public AppMessage(Builder builder) {
            messageId = builder.messageId;
            sendId = builder.sendId;
            content = builder.content;
            imageUrl = builder.imageUrl;
            title = builder.title;
            boxType = builder.boxType;
            expiryDay = builder.expiryDay;
            sendTime = builder.sendTime;
            extData = builder.extData;
            ofPush = builder.ofPush;
        }
    }

}
