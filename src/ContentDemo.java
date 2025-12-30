import java.time.Year;
import java.util.ArrayList;

// ===== Demo Class =====
public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2023, 120, "HD"));
        items.add(new VideoLecture("Advanced OOP", 2022, 90, "4K"));
        items.add(new PodcastEpisode("TechTalk", 2024, 45, "Alice"));
        items.add(new PodcastEpisode("CodeCast", 2021, 60, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item.toString() +
                    " | licenseCost=" + item.getLicenseCost(currentYear));
            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads/day = " + d.getMaxDownloadsPerDay());
            }
            System.out.println();
        }
    }
}
