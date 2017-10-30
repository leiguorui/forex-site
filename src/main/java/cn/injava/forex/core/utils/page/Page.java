package cn.injava.forex.core.utils.page;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis分页参数及查询结果封装. 注意所有序号从1开始.
 * 
 * @param <T>
 *            Page中记录的类型.
 * @author StarZou
 * @since 2014年5月18日 下午1:34:32
 **/
public class Page<T> extends RowBounds {
    // --分页参数 --//
    /**
     * 页编号 : 第几页
     */
    protected int pageNo = 1;
    /**
     * 页大小 : 每页的数量
     */
    protected int pageSize = 15;

    /**
     * 偏移量 : 第一条数据在表中的位置
     */
    protected int offset;

    /**
     * 限定数 : 每页的数量
     */
    protected int limit;

    // --结果 --//
    /**
     * 查询结果
     */
    protected List<T> result = new ArrayList<T>();

    /**
     * 总条数
     */
    protected int totalCount;

    /**
     * 总页数
     */
    protected int totalPages;

    // --计算 数据库 查询的参数 : LIMIT 3, 3; LIMIT offset, limit; --//
    /**
     * 计算偏移量
     */
    private void calcOffset() {
        this.offset = ((pageNo - 1) * pageSize);
    }

    /**
     * 计算限定数
     */
    private void calcLimit() {
        this.limit = pageSize;
    }

    // -- 构造函数 --//
    public Page() {
        this.calcOffset();
        this.calcLimit();
    }

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.calcOffset();
        this.calcLimit();
    }

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNo - 1) * pageSize) + 1;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
     */
    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    // -- 访问查询结果函数 --//
    /**
     * 取得页内的记录列表.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setResult(final List<T> result) {
        this.result = result;
    }

    /**
     * 取得总记录数, 默认值为-1.
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数.
     */
    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = this.getTotalPages();
    }

    //-----------获取页数------------

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPages() {
        return (totalCount + pageSize - 1) / pageSize;
    }

    /**
     * 取得首页
     *
     * @return
     */
    public int getTopPageNo() {
        return 1;
    }

    /**
     * 上一页
     *
     * @return
     */
    public int getPreviousPageNo() {
        if (pageNo <= 1) {
            return 1;
        }
        return pageNo - 1;
    }

    /**
     * 下一页
     *
     * @return
     */
    public int getNextPageNo() {
        if (pageNo >= getBottomPageNo()) {
            return getBottomPageNo();
        }
        return pageNo + 1;
    }

    /**
     * 取得尾页
     *
     * @return
     */
    public int getBottomPageNo() {
        return getTotalPages();
    }

    /**
     * 取得可以显示的页码
     *
     * @return
     */
    public List<String> getPageNos() {
        int firstPageNo = 1;
        int loopSize = getTotalPages();
        int totalPages = getTotalPages();
        int pageNoDisplay = 5;

        if (totalPages > pageNoDisplay) {
            firstPageNo = pageNo - 2;
            loopSize = pageNo + 2;

            if (firstPageNo < 1) {
                firstPageNo = 1;
                loopSize = pageNoDisplay;
            }
            if (loopSize > totalPages) {
                firstPageNo = totalPages - pageNoDisplay + 1;
                loopSize = totalPages;
            }
        }

        List<String> pageNos = new ArrayList<>();

        if (firstPageNo != 1) {
            pageNos.add("···");
        }
        for (int n = firstPageNo; n <= loopSize; n++) {
            pageNos.add(n + "");
        }
        if (loopSize != totalPages) {
            pageNos.add("···");
        }

        return pageNos;
    }


    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
