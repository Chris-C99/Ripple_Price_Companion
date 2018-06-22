package com.example.chris.ripplepricecompanion;

/**
 * Created by chris on 1/10/18.
 */

public class contents {

    private String id;
    private String rank;
    private String price_usd;
    private String price_btc;
    private String market_cap_usd;
    private String total_supply;
    private String available_supply;
    private String max_supply;
    private String percent_change_1h;
    private String percent_change_24h;
    private String percent_change_7d;

    public contents(String id, String rank, String price_usd, String price_btc, String market_cap_usd, String total_supply, String available_supply, String max_supply, String percent_change_1h, String percent_change_24h, String percent_change_7d) {
        this.id = id;
        this.rank = rank;
        this.price_usd = price_usd;
        this.price_btc = price_btc;
        this.market_cap_usd = market_cap_usd;
        this.total_supply = total_supply;
        this.available_supply = available_supply;
        this.max_supply = max_supply;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
    }

    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }
}
/*
        "id": "ripple",
        "name": "Ripple",
        "symbol": "XRP",
        "rank": "3",
        "price_usd": "1.97344",
        "price_btc": "0.00013664",
        "24h_volume_usd": "5415420000.0",
        "market_cap_usd": "76449373989.0",
        "available_supply": "38739142811.0",
        "total_supply": "99993093880.0",
        "max_supply": "100000000000",
        "percent_change_1h": "-1.28",
        "percent_change_24h": "-12.45",
        "percent_change_7d": "-35.88",
        "last_updated": "1515614041"
*/