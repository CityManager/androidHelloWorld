package ind.example.xuweiman.helloworld.utils;

import java.util.ArrayList;
import java.util.List;

import ind.example.xuweiman.helloworld.n03_customViews.bestUIPractice.Msg;

public class MsgUtil {
    public static List<Msg> initMsgList() {
        List<Msg> msgList = new ArrayList<>();
        Msg msg = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg);
        Msg msg1 = new Msg("Hello. Who is that?", Msg.TYPE_SEND);
        msgList.add(msg1);
        Msg msg2 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg2);
        return msgList;
    }
}
