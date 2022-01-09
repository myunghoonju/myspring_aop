package logChaser.aop.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("call MessageDecorator");
        String result = component.operation();
        String decoResult = "**" + result + "**";
        log.info("MessageDecorator result = {}, decoresult = {}", result, decoResult);

        return decoResult;
    }
}
