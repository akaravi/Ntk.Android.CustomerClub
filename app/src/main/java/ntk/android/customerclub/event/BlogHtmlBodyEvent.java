package ntk.android.customerclub.event;

public class BlogHtmlBodyEvent {

    private String Html;

    public BlogHtmlBodyEvent(String m) {
        this.Html = m;
    }

    public String GetMessage() {
        return Html;
    }
}
