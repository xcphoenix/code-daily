package xuanc;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName    Chapter15-FileWriterTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午4:01
 */
public class FileWriterTest {

    public static void main(String[] args) {
        try (
                FileWriter fw = new FileWriter("poem.txt")
        ) {
            fw.write("我出生之时尚无为，我出生之后蛮已衰...\n");
            fw.write("天不仁兮降乱离，地不仁兮使我乌山殇。\n");
            fw.write("干戈起兮月碎纷非，陌于南兮家路哀悲……\n");
            fw.write("若天有眼兮何不见我永世沉沦黑？\n");
            fw.write("若神有灵兮何事分我天南海北离？\n");
            fw.write("我不负天兮天何让我不见夜之黑？\n");
            fw.write("我不负神兮神何殛我血肉忆纷飞！！\n");
            fw.write("...\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
