package cn.injava.forex.core;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * TestSupport : Spring����֧��,���ڲ�����Spring �����bean,��д������ʱ,�̳и���
 *
 * @author StarZou
 * @since 2014��5��18�� ����2:28:58
 */
@ContextConfiguration(locations = {"classpath*:spring-web-servlet.xml"})
public class TestSupport extends AbstractJUnit4SpringContextTests {
    protected long startTime;
    protected long endTime;

    /**
     * ��¼ ��ʼ����ʱ��
     *
     * @return
     */
    protected long start() {
        this.startTime = System.currentTimeMillis();
        return startTime;
    }

    /**
     * ��¼ ��������ʱ��
     *
     * @return
     */
    protected long end() {
        this.endTime = System.currentTimeMillis();
        this.log();
        return endTime;
    }

    /**
     * �����¼
     */
    protected void log() {
        String text = "\n��ʼʱ�� : " + this.startTime + "\n����ʱ�� : " + this.endTime + "\nִ��ʱ�� : " + (this.endTime - this.startTime);
        logger.info(text);
    }
}