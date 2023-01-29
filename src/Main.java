import service.CalisanService;
import service.SirketService;

public class Main {
    public static void main(String[] args) {

            CalisanService calisanService = new CalisanService();
            SirketService sirketService = new SirketService();
            sirketService.read();
            calisanService.read();
        }
    }
