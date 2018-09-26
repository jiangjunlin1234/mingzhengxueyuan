import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class TestUnit {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebClient client = new WebClient(BrowserVersion.FIREFOX_38);
        client.waitForBackgroundJavaScript(3000);
         client.getOptions().setJavaScriptEnabled(true);
         client.getOptions().setCssEnabled(false);
         client.getOptions().setThrowExceptionOnScriptError(false);
         client.getOptions().setRedirectEnabled(true);
         client.getCache().setMaxSize(0);
         client.setAjaxController(new NicelyResynchronizingAjaxController());//支持AJAX
         HtmlPage page = client.getPage("http://jw2.csmzxy.com:8088/");
         System.out.println(page.asText());
        System.out.println("----------登录前---------");
         //账号密码框
        HtmlInput username = (HtmlInput) page.getElementById("TextBox1");
        HtmlInput pwd = (HtmlInput) page.getElementById("TextBox2");
        //提交框
        HtmlInput sub = (HtmlInput) page.getElementById("Button1");
        //验证码图片
        HtmlImage vaCode=(HtmlImage) page.getElementById("icode");
        UUID uuid = UUID.randomUUID();
        File file=new File("images/"+uuid+".gif");
        vaCode.saveAs(file);
        //验证码输入框
        HtmlInput code = (HtmlInput) page.getElementById("TextBox3");

        //给账号密码以及验证码赋值
        username.setAttribute("value","1625123745");
        pwd.setAttribute("value","lovexxx");
        TestGraphiccr testGraphiccr = new TestGraphiccr();
        code.setAttribute("value",testGraphiccr.code("images/"+uuid+".gif"));

        //提交
        HtmlPage pageLogin = sub.click();
        System.out.println(pageLogin.asText());
        System.out.println("----------成功登录---------");
        /*HtmlPage page3 = client.getPage("http://jw3.csmzxy.com:8088/xscjcx.aspx?xh=1625123745&xm=%BD%AD%BF%A1%C1%D8&gnmkdm=N121605");
        Thread.sleep(4000);
        System.out.println(page3.asText());
        */

       /* List<HtmlSpan> spanList= (List<HtmlSpan>) page.getByXPath("//li[@class='top']/ul/li/a");
        System.out.println(spanList.get(0).asText());
        */

       /* DomNodeList<DomElement> down = pageLogin.getElementsByTagName("li");
            HtmlPage downClick = down.get(2).click();
            System.out.println(downClick.asText());*/

       /* DomNodeList<DomElement> li = downClick.getElementsByTagName("li");
        HtmlPage liClick = li.get(11).click();
        System.out.println(liClick.asText());*/
    }
}
