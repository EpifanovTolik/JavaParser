package firstApp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "checker")
@RequestScoped
public class Checker {

    /**
     * Список , куда будут складываться ссылки
     */
    private static final List<Refer> referArrayList = new ArrayList<>();

    public List<Refer> getReferArrayList() {

        return referArrayList;

    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Основной метод парсинга.
     * Сначала очищает список, если он был заполнен.
     * Потом парсит входящий url.
     * Выбирает по тэгам нужные нам ссылки.
     * Складываем их в список.
     *
     */
    public void checkListRefer() throws IOException {
        referArrayList.clear();

        Document page = Jsoup.parse(new URL(url), 3000);

        Elements links = page.select("a[href]");
        for (Element link : links) {

            referArrayList.add(new Refer(link.text(), link.attr("href")));
        }
    }


    /**
     *
     * @return Возвращает список названий ссылок
     *
     */
    public List<String> checkNameOfAllRef() {
        List<String> list = new ArrayList<>();
        for (Refer elem : referArrayList) {
            list.add(elem.name);
        }
        return list;
    }

    /**
     *
     * @return Возвращает список самих ссылок
     *
     */
    public List<String> checkReferOfAllRef()  {
        List<String> list1 = new ArrayList<>();
        for (Refer elem : referArrayList) {
            list1.add(elem.address);
        }
        return list1;
    }


}




