package cs.start;

import cs.model.MSettings;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.CsvDataFormat;

import java.lang.reflect.Type;
import java.util.List;

public class Main {
    private static CamelContext ctx;

    public Main() throws Exception {
        MSettings sett = JsonSettings();
        ctx = new DefaultCamelContext();

//        CamelStart("C:/Users/Samir/Desktop/all/", "C:/Users/Samir/Desktop/in/");

        for (var s : sett.routes)
        {
            System.out.println( "Start: " + s.Name);
            CamelStart(s.path_from, s.path_to);
        }

        ctx.start();
        Thread.sleep(71000);
    }

    private static MSettings JsonSettings()
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(Main.class.getClassLoader().getResource("settings.json"), MSettings.class);

        } catch (Exception ex) {
            System.out.println("oshibka");
            return null;
        }
    }

    public static void CamelStart(String from, String to) throws Exception {
        CsvDataFormat csv = new CsvDataFormat();
        csv.setDelimiter(";");

        RouteBuilder route = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://" + from + "?noop=true")
                        .to("file://" + to)
                .unmarshal(csv)
                .convertBodyTo(List.class)
                .process(Main::CamelProcess)
                ;
            }
        };

        ctx.addRoutes(route);
        //ctx.stop();
    }

    public static void CamelProcess(Exchange exch)
    {
        @SuppressWarnings("unchecked")
        List<List<String>> data = (List<List<String>>) exch.getIn().getBody();

        for (List<String> line : data) {
            for (String s : line) {
                System.out.print(". " + s);
            }
            System.out.println();
        }
    }
}