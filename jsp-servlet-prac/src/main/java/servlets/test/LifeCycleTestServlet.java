package servlets.test;

import io.reactivex.rxjava3.core.Observable;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow")
public class LifeCycleTestServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("init called");
        Observable<String> source = Observable.create(e -> {
            e.onNext("Hello");
            e.onNext("RxJava");
        });
        source.subscribe(e -> System.out.println("Observer 1 :" + e + " Thread Name : " + Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2 :" + e + " Thread Name : " + Thread.currentThread().getName()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
        System.out.println("http get req called");
        System.out.println(this);
        System.out.println("getRemoteAddr : " +  req.getRemoteAddr());
        System.out.println("getRemoteHost : " +  req.getRemoteHost());
        System.out.println("getRemotePort : " +  req.getRemotePort());
        System.out.println("getRemoteUser : " +  req.getRemoteUser());
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Hello</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy called");
        super.destroy();
    }
}
