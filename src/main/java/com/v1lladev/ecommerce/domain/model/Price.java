package com.v1lladev.ecommerce.domain.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Price.
 */
public class Price {

    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Byte priority;
    private BigDecimal price;
    private String curr;

    /**
     * Instantiates a new Price.
     */
    public Price() {
    }

    /**
     * Instantiates a new Price.
     *
     * @param id        the id
     * @param brandId   the brand id
     * @param startDate the start date
     * @param endDate   the end date
     * @param priceList the price list
     * @param productId the product id
     * @param priority  the priority
     * @param price     the price
     * @param curr      the curr
     */
    public Price(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId, Byte priority, BigDecimal price, String curr) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets brand id.
     *
     * @return the brand id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * Sets brand id.
     *
     * @param brandId the brand id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Sets end date.
     *
     * @param endDate the end date
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets price list.
     *
     * @return the price list
     */
    public Long getPriceList() {
        return priceList;
    }

    /**
     * Sets price list.
     *
     * @param priceList the price list
     */
    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public Byte getPriority() {
        return priority;
    }

    /**
     * Sets priority.
     *
     * @param priority the priority
     */
    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets curr.
     *
     * @return the curr
     */
    public String getCurr() {
        return curr;
    }

    /**
     * Sets curr.
     *
     * @param curr the curr
     */
    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price prices = (Price) o;
        return Objects.equals(id, prices.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
