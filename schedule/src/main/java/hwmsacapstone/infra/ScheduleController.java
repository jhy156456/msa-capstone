package hwmsacapstone.infra;

import hwmsacapstone.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;
import java.lang.reflect.Field;
@RestController
@RequestMapping(value = "/schedules")
@Transactional
public class ScheduleController {

    @Autowired
    ScheduleRepository scheduleRepository;
    // keep

    // @GetMapping("/callMemleak")
    // public void callMemleak() {
    //     try {
    //         this.memLeak();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void memLeak() throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
    //     Class unsafeClass = Class.forName("sun.misc.Unsafe");
    //     Field f = unsafeClass.getDeclaredField("theUnsafe");
    //     f.setAccessible(true);
    //     Unsafe unsafe = (Unsafe) f.get(null);
    //     System.out.print("4..3..2..1...");
    //     try {
    //         for (; ; )
    //             unsafe.allocateMemory(1024 * 1024);
    //     } catch (Error e) {
    //         System.out.println("Boom :)");
    //         e.printStackTrace();
    //     }
    // }

}
