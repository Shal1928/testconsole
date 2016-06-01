package archive;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;
import others.QueueKey;
import others.SOP;
import others.Synchronised;
import ru.blogic20.easy_java_development_kit.misc.ResourceHelper;
import ru.blogic20.easy_java_development_kit.settings.parser.SettingsParser;
import ru.blogic20.easy_subscription_development_kit.filenet.connection.parts.User;

import javax.security.auth.Subject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;
import static ru.blogic20.easy_subscription_development_kit.filenet.ce.parts.LogMessageHelper.f;

/**
 *
 */
public class TIsForTest {

    public void main(){




        Calendar c1 = Calendar.getInstance();

        Calendar c2 = Calendar.getInstance();

        c2.set(Calendar.HOUR_OF_DAY, 16);
        c2.set(Calendar.MINUTE, 4);

        System.out.println("c1 = "+c1.getTime());
        System.out.println("c2 = "+c2.getTime());

        System.out.println("c1.compareTo(c2) = " + c1.compareTo(c2));

//            c1>c2=1
//            c1<c2=-1





        String query = "f.FolderStatus != 'RUNNING' AND f.FolderStatus != 'COLLECTING'\n";

        String m1 = format("{0}{1}{0}", ".*", "!=");
        Pattern p = Pattern.compile(m1, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
        Matcher m = p.matcher(query);



        boolean b1 = m.matches();//query.matches(m1);
        System.out.println(format("b1 = {0}; m1 = {1}", b1, m1));

        System.out.println("Final");





        ResourceHelper.setResourcePath("C:\\");
//        SettingsParser.setSettingsFileName("SettingsEnum.xml");
//            GeneralSettings lgs = SettingsParser.readConfiguration(GeneralSettings.class);
//
//            GeneralSettings gs = new GeneralSettings();
//            gs.setValue("Val");
//            gs.setTypeID(TypeID.STRING_AS_INT);

        int i = 0;
        Collection<Integer> ic = new ArrayList<Integer>();
        ic.add(3);
        ic.add(56);
        ic.add(10);
//            for(int j : ic){
//                i |= j;
//            }

        //i = 3 | 56 | 10;

//            gs.setEnumVal(null);

//            gs.setObjects(new Object[]{"1s", 1, new Date()});

        ResourceHelper.setResourcePath("C:\\");
//        SettingsParser.setSettingsFileName("SettingsEnum.xml");
//            SettingsParser.writeConfiguration(gs);




        Date date = new Date();
        System.out.println(date);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        System.out.println("GMT +08:00: " + dateFormat.format(date));

        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS'Z'");
        dateFormat.setTimeZone(TimeZone.getDefault());
        System.out.println("GMT D: " + dateFormat.format(date));





        User user = new User("pe_service_user_vn", "Dbityrf_556");
//            User user = new User("vankor_dev", "Asd123456");
//            1010328915
        String ceURI = "http://10.44.60.200:9080/wsi/FNCEWS40MTOM/";

        Connection connection = Factory.Connection.getConnection(ceURI);
        Domain domain = Factory.Domain.getInstance(connection, "Vankor");

        Subject subject = UserContext.createSubject(connection, user.getLogin(), user.getPassword(), "FileNetP8WSI");
        UserContext uc = UserContext.get();
        uc.pushSubject(subject);

        //Domain domain = Factory.Domain.fetchInstance(connection, "Vankor", null);


        ObjectStore os = Factory.ObjectStore.fetchInstance(domain, "OUTBOX", null);
//            ObjectStore os = Factory.ObjectStore.getInstance(domain, "OUTBOX");

//            VWSession session = new VWSession();
//            session.setBootstrapCEURI(ceURI);
//            session.logon(user.getLogin(), user.getPassword(), "OUTBOX");
//
//            VWQueue queue = session.getQueue("GDRNUchet");
//
//
////            iiop://10.44.60.76:2809/FileNet/Engine
//
////            String[] queues = session.fetchQueueNames(VWSession.QUEUE_USER_CENTRIC_FOR_USER_ONLY);
//            //VWStepElement ui = session.createWorkflow("Исходящие услуги");//.fetchRosterNames(false);
//
//            int a = 1;
//            for(String q:queues)
//                System.out.println(q);
//
//        VWQueueQuery q1 = pe.getSession().getQueue().createQuery("", null, null, 1, "", null, 1);
//
//        get a step element
//            vwStepElement = queueHelper.getStepElement(vwQueue);
//            if (vwStepElement != null) {
//                // lock the record
//                vwStepElement.doLock(true);
//
//                // set the comments
//                vwStepElement.setComment("This is the user's comment.");
//
//                // display the Step Processor information
//                logger.displayStepElementInfo(vwStepElement);
//
//                // complete the step
//                logger.log("Completing step: " + vwStepElement.getOperationName());
//                vwStepElement.doDispatch();
//            }


        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---");

        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---");





        QueueKey key = getKey();
        System.out.println(key.getKey());

        Synchronised.main(null);

//        if(true){
//            for(int i = 0; i < 9999999; i++){
//
//            }
//            //return;
//        }

//            ClassOne one = null;
//            System.out.println(one.getString());
//
////            System.out.println(new ClassOne().getOne());
//            System.out.println("new ClassTwo().getOne(): " + new ClassTwo().getOne());
//
//            System.out.println("new ClassThree().getOne(): "+new ClassThree().getOne());
//            System.out.println("new ClassThree().getThree(): " + new ClassThree().getThree());
//
//            Object obj = "1";
//            Comparable c = (Comparable) obj;
//            System.out.println(c);
//
//            obj = null;
//            Comparable c2 = (Comparable)obj;
//            System.out.println(c2);
//
//            System.out.println(getNumber());
//
//            System.out.println(MiscHelper.formatToFNDate(new Date()));
//            System.out.println(MiscHelper.formatToFNDate(new Date(), "+07:00"));
//            System.out.println(MiscHelper.formatToFNDate(new Date(), "-07:00"));
//
//            String fnDateFormat = "yyyy-MM-dd'T'HH:mm:ss";
//            DateFormat dateFormat = new SimpleDateFormat(fnDateFormat);
//            dateFormat.setTimeZone(TimeZone.getTimeZone(format("GMT{0}", "7")));
//            System.out.println(dateFormat.format(new Date()));

//            Calendar c = Calendar.getInstance();
//            System.out.println(c.get(Calendar.DAY_OF_MONTH));
//            System.out.println(c.get(Calendar.MONTH));
//            System.out.println(c.get(Calendar.YEAR));

//            HashMap<String, Integer> map = new HashMap<String, Integer>();
//            map.put("1", 1);
//            map.put("2", 1);
//
//            System.out.println(map.get("3"));
//            System.out.println(map.get(null));
//
//            HashSet<ProcessingObject> set = new HashSet<ProcessingObject>();
//
//            ProcessingObject p2 = new ProcessingObject(new HardObj("id2", "value2"));
//            set.add(new ProcessingObject(new HardObj("id1", "value1")));
//            set.add(p2);
//            set.add(new ProcessingObject(new HardObj("id3", "value3")));
//            set.add(new ProcessingObject(new HardObj("id1", "value11")));
//            set.add(new ProcessingObject(new HardObj("id1", "value111")));
//
//            for(ProcessingObject o : set)
//                System.out.println(o.get().id+" "+o.get().value);
//
//            System.out.println("");
//
//            System.out.println(set.contains(new ProcessingObject(new HardObj("id2", "value2"))));

        for(QueueKey k : Synchronised.getMap().keySet())
            SOP.print(f("*Key: {0} IsTaken: {1} IsFinished: {2}", k.getKey(), k.isTaken(), k.isFinished()));

        System.out.println("");
//            c1>c2=1
//            c1<c2=-1

//            for(Integer i:col1)
//                System.out.println(i);


//            String query = "SELECT o.This, o.DateDoc, o.DateCreated\n" +
//                    "                      FROM OutboxInvoice o\n" +
//                    "                      WHERE o.BulkOperationId != {0}\n" +
//                    "                      AND o.Curator = 'Куратор миграции'\n" +
//                    "                      AND o.IsCurrentVersion = true\n" +
//                    "                      AND o.FinanceYear = '2014'\n" +
//                    "                      AND o.This INSUBFOLDER '/Исходящие услуги/Пакеты документов'\n" +
//                    "                      ORDER BY o.DateCreated ASC";
//
//            String m1 = format("^SELECT (.[^\\.]*)+ FROM.*");
//            Pattern p = Pattern.compile(m1, Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
//            Matcher m = p.matcher(query);
//
//
//
//            boolean b1 = m.matches();//query.matches(m1);
//            System.out.println(format("b1 = {0}; m1 = {1}", b1, m1));
    }

    int getNumber(){
        try{
            return 0;
        }catch (Exception e){
            return 1;
        }finally {
            return 2;
        }
    }

    private QueueKey currentKey;

    private QueueKey getKey(){
        boolean isNeedNew = false;
        try{
            currentKey = new QueueKey(1);
            isNeedNew = true;
            return currentKey;
        }finally {
            if(isNeedNew) currentKey = new QueueKey(2);
        }
    }

    private <T> T checker(){
        Object o = new Object();
        T genericMemeber = (T)o;

        if(genericMemeber == String.class)

            if(genericMemeber instanceof Boolean) {
                throw new RuntimeException("Boolean");
            }
        if(genericMemeber instanceof Integer) {
            throw new RuntimeException("Integer");
        }

        if(genericMemeber instanceof String) {
            throw new RuntimeException("String");
        }

        return genericMemeber;
    }

    private String getRegEx(int index){
        return format("['{'][{0}]['}']", index);
    }
}
