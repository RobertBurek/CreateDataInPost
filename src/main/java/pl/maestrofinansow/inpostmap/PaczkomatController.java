package pl.maestrofinansow.inpostmap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PaczkomatController {

    PaczkomatRepository paczkomatRepository;

    public PaczkomatController(PaczkomatRepository paczkomatRepository) {
        this.paczkomatRepository = paczkomatRepository;
    }

    @Value("${myapp.url}")
    public String url;


    @GetMapping("/getpaczkomaty")
    public String getPaczkomaty() {
        RestTemplate restTemplate = new RestTemplate();
        String values = restTemplate.getForObject(url, String.class);
        String[] lines = values.split("<div style=\"margin: 0 0 8px 30px\">");
        String[] linia;
//        int i = 1;
        List<String> nowaL = new ArrayList<>();
        for (String st : lines) {
            if ((st.startsWith("<h4>")) && (st.contains("Zobacz na Mapie Google"))) {
                st = st.replace(st.substring(st.indexOf("</b></a></div>") + 4, st.length()), "");
                linia = st.split(">");
//                System.out.println(st);
                for (String znak : linia) {
                    if ((!znak.startsWith("<")) && (!znak.endsWith("</a"))) {
                        znak = znak.replace(znak.substring(znak.indexOf("<"), znak.length()), "");
                        nowaL.add(znak);
                    }
                }
                Paczkomat paczkomat = new Paczkomat();
                paczkomat.setGdzie(nowaL.get(0).trim());
                paczkomat.setNrPaczkomatu(nowaL.get(1));
                paczkomat.setUlica(nowaL.get(2));
                paczkomat.setKod(nowaL.get(3).substring(0, 6));
                paczkomat.setMiasto(nowaL.get(3).substring(7));
                paczkomat.setWspX(Double.parseDouble(nowaL.get(4).substring(0, 7)));
                paczkomat.setWspY(Double.parseDouble(nowaL.get(4).substring(13, 20)));
                System.out.println(paczkomat);
                nowaL.clear();
                paczkomatRepository.save(paczkomat);
//                if (i == 2) break;
//                i++;
            }
        }
        return "map";
    }
}
