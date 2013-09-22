package org.hasor.test.web.app.beans;
import java.io.IOException;
import net.hasor.core.context.AnnoStandardAppContext;
import net.hasor.core.gift.bean.Bean;
import org.hasor.test.plugins.log.OutLog;
import org.hasor.test.plugins.safety.Power;
import org.hasor.test.plugins.safety.SafetyContext;
/**
 * 
 * @version : 2013-7-25
 * @author ������ (zyc@hasor.net)
 */
@Bean("SafeBean")
public class SafeBean {
    @OutLog
    @Power("abc")
    public void print() {
        System.out.println("�ڴ�֮ǰ�����־!");
    }
    //
    //
    public static void main(String[] args) throws IOException {
        AnnoStandardAppContext aac = new AnnoStandardAppContext();
        aac.start();
        //
        SafeBean safeBean = (SafeBean) aac.getBean("SafeBean");
        SafetyContext sc = aac.getInstance(SafetyContext.class);
        System.out.println("--------��Ȩ�޵���------");
        try {
            safeBean.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------��Ȩ�޵���------");
        try {
            sc.addPower("abc");
            safeBean.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
    }
}