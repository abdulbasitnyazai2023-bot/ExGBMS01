import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

public class MyBarChart extends JFrame {

    public MyBarChart(String title) {
        super(title);

        // ۱. د معلوماتو (Dataset) جوړول
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, "خرڅلاو", "مڼې");
        dataset.addValue(150, "خرڅلاو", "مالټې");
        dataset.addValue(300, "خرڅلاو", "انګور");
        dataset.addValue(100, "خرڅلاو", "آم");

        // ۲. د نمودار (Chart) جوړول
        JFreeChart barChart = ChartFactory.createBarChart(
                "د میوو د پلور راپور",           // سرلیک
                "میوه",                         // د X محور نوم
                "اندازه (کیلو)",                // د Y محور نوم
                dataset,                        // معلومات
                PlotOrientation.VERTICAL,       // د ستونونو بڼه
                true, true, false);

        // ۳. په یوه پینل کې د چارټ ځای پر ځای کول
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        MyBarChart chart = new MyBarChart("زموږ لومړی چارټ");
        chart.pack();
        chart.setVisible(true);
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}