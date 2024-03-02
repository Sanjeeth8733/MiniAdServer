import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Site class represents a website where ads can be displayed
class Site {
    int siteId;
    int reservePrice;
    String siteUrl;

    public Site(int siteId, int reservePrice, String siteUrl) {
        this.siteId = siteId;
        this.reservePrice = reservePrice;
        this.siteUrl = siteUrl;
    }
}

// Ad class represents an advertisement that can be displayed on multiple sites
class Ad {
    int adId;
    int bidPrice;
    Set<Integer> siteIds;

    public Ad(int adId, int bidPrice, Set<Integer> siteIds) {
        this.adId = adId;
        this.bidPrice = bidPrice;
        this.siteIds = siteIds;
    }
}

public class MiniAdServer {
    List<Site> sites;
    List<Ad> ads;

    public MiniAdServer(String sitesPath, String adsPath) {
        sites = new ArrayList<>();
        ads = new ArrayList<>();
        readSites(sitesPath);
        readAds(adsPath);
    }

    // Read site data from a CSV file
    private void readSites(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int siteId = Integer.parseInt(parts[0]);
                int reservePrice = Integer.parseInt(parts[1]);
                String siteUrl = parts[2];
                sites.add(new Site(siteId, reservePrice, siteUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read ad data from a CSV file
    private void readAds(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int adId = Integer.parseInt(parts[0]);
                int bidPrice = Integer.parseInt(parts[1]);
                int numSites = Integer.parseInt(parts[2]);
                Set<Integer> siteIds = new HashSet<>();
                for (int i = 3; i < 3 + numSites; i++) {
                    siteIds.add(Integer.parseInt(parts[i]));
                }
                ads.add(new Ad(adId, bidPrice, siteIds));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find the highest bidding ad for a given site and display its ID and second highest bid price
    public void findAd(int siteId) {
        int maxBid = 0;
        int secondMaxBid = 0;
        int winningAdId = 0;

        for (Ad ad : ads) {
            if (ad.siteIds.contains(siteId)) {
                for (Site site : sites) {
                    if (site.siteId == siteId && ad.bidPrice >= site.reservePrice) {
                        if (ad.bidPrice > maxBid) {
                            secondMaxBid = maxBid;
                            maxBid = ad.bidPrice;
                            winningAdId = ad.adId;
                        } else if (ad.bidPrice > secondMaxBid) {
                            secondMaxBid = ad.bidPrice;
                        }
                    }
                }
            }
        }

        if (winningAdId != 0) {
            System.out.println(winningAdId + " " + secondMaxBid);
        } else {
            System.out.println("0 0");
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MiniAdServer sites.csv ads.csv");
            return;
        }

        MiniAdServer adServer = new MiniAdServer(args[0], args[1]);

        Scanner scanner = new Scanner(System.in);
        int siteId;
        while ((siteId = scanner.nextInt()) != -1) {
            adServer.findAd(siteId);
        }
    }
}

