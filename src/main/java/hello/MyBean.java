package hello;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "myBean")
@SessionScoped
public class MyBean {
    private List<SampleData> dataList;
    private List<SampleData> currentPageData;
    private int currentPage = 1;
    private int totalPages;
    private int pageSize = 10;
    private int[] availablePageSizes = {5, 10, 20, 50};
    private List<Integer> pages;
    
    public MyBean() {
        initializeData();
    }
    
    private void initializeData() {
        // Initialize data list
        dataList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            dataList.add(new SampleData(i, "Item " + i));
        }
        
        // Initial calculations
        calculateTotalPages();
        loadPageData();
        generatePageNumbers();
    }
    
    // Sample data model
    public static class SampleData {
        private int id;
        private String name;
        
        public SampleData(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public int getId() { return id; }
        public String getName() { return name; }
    }

    // Calculate total pages based on current data and page size
    private void calculateTotalPages() {
        totalPages = (int) Math.ceil((double) dataList.size() / pageSize);
    }

    // Load data for current page
    private void loadPageData() {
        int start = (currentPage - 1) * pageSize;
        int end = Math.min(start + pageSize, dataList.size());
        currentPageData = dataList.subList(start, end);
    }

    // Generate page numbers to display
    private void generatePageNumbers() {
        pages = new ArrayList<>();
        int startPage = Math.max(1, currentPage - 2);
        int endPage = Math.min(totalPages, currentPage + 2);
        
        for (int i = startPage; i <= endPage; i++) {
            pages.add(i);
        }
    }

    // Navigation methods
    public void goToPage(int page) {
        currentPage = page;
        loadPageData();
        generatePageNumbers();
    }
    
    public void firstPage() {
        goToPage(1);
    }
    
    public void previousPage() {
        if (currentPage > 1) {
            goToPage(currentPage - 1);
        }
    }
    
    public void nextPage() {
        if (currentPage < totalPages) {
            goToPage(currentPage + 1);
        }
    }
    
    public void lastPage() {
        goToPage(totalPages);
    }
    
    public void onPageSizeChange() {
        currentPage = 1;
        calculateTotalPages();
        loadPageData();
        generatePageNumbers();
    }
    
    // Getters and setters
    public List<SampleData> getCurrentPageData() {
        return currentPageData;
    }
    
    public int getCurrentPage() { return currentPage; }
    
    public int getTotalPages() { return totalPages; }
    
    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { 
        this.pageSize = pageSize;
        onPageSizeChange();
    }
    
    public int[] getAvailablePageSizes() { return availablePageSizes; }
    
    public List<Integer> getPages() {
        return pages;
    }
    
    public List<SampleData> getDataList() {
        return dataList;
    }
}