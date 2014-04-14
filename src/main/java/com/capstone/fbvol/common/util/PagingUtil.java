package com.capstone.fbvol.common.util;

/**
* 페이징 관련 정보
* <p>
* <code>사용방법:</code><br>
*  PagingUtil paging = new PagingUtil();<br>
*  paging.setPageSize(10);<br>
*  paging.setRowCount(2035);<br>
*  paging.setCurrentPage(2);<br>
* <br>
*  String first = paging.getFirst("[처음]");<br>
*  String last = paging.getLast("[마지막]");<br>
*  String prev = paging.getPrev("[이전]");<br>
*  String next = paging.getNext("[다음]");<br>
*  String pages = paging.getPages()<br>
*/
public class PagingUtil
{
    // Paging 관련
    private int         rowCount;           // 게시물 수
    private int         currentPage;        // 현재 페이지
    private int         pageSize = 10;      // 페이지당 글 수
    private int         pageCount;          // 페이지 수
    private int         blockSize = 10;     // 블럭당 페이지 수
    private int         beginOB;            // 블럭의 첫번째 페이지
    private int         endOB;              // 블럭의 마지막 페이지
    private int         first = 1;          // 가장 첫번째 페이지
    private int         next;               // 다음 블럭 첫번째 페이지
    private int         prev;               // 이전 블럭 마지막 페이지
    private int         last;               // 가장 마지막 페이지 (pageCount와 같다)

    /*
    * 생성자 메소드
    */
	public PagingUtil()
    {
        rowCount    = 0;
        currentPage = 1;
        pageCount   = 1;
        beginOB     = 1;
        endOB       = 1;
    }
	
	public PagingUtil(int pageSize,int blockSize,int totCnt,int currPage)
    {
        this();
		setPageSize(pageSize);
		setBlockSize(blockSize);
		setRowCount(totCnt);
		setCurrentPage(currPage);
    }

	
    public void setBlockSize(int blockSize){
		this.blockSize = blockSize;
	}
    public int getPageSize()
    {
        return pageSize;
    }

    /**
    * 한 페이지에 표시될 게시물의 수를 설정한다
    * <p>
    * @param size 한 페이지에 표시될 게시물 수
    */
    public void setPageSize(int size) {
        pageSize = size;
    }

    /**
    * 전체 게시물 수를 설정한다.
    * <p>
    * @param rowCount 전체 게시물 수
    */
    public void setRowCount(int rowCount)
    {
        this.rowCount = rowCount;
        // pageCount
        pageCount = (int) Math.ceil((double)rowCount / pageSize);
        pageCount = pageCount == 0 ? 1 : pageCount;
    }

    public int getRowCount()
    {
        return rowCount;
    }
    
	public int getPageCount()
	{
		return pageCount;
	}

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
        // currentBlock
        int currentBlock = (int) Math.ceil((double)currentPage / blockSize);
        // beginOB
        beginOB = blockSize * (currentBlock - 1) + 1;
        // endOB
        endOB = blockSize * currentBlock;
        endOB = endOB < pageCount ? endOB : pageCount;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public int getBeginOB()
    {
        return beginOB;
    }

    public int getEndOB()
    {
        return endOB;
    }

    /**
    * 첫 페이지를 구한다
    * <p>
    * @param icon 화면에 표시될 아이콘(텍스트) 문자열
    */
    public String getFirst(String icon)
    {
        if(getBeginOB() == 1) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + first + ")'>" + icon + "</a>";
        }
    }

    /**
    * 이전 블록의 마지막 페이지를 구한다
    * <p>
    * @param icon 화면에 표시될 아이콘(텍스트) 문자열
    */
    public String getPrev(String icon)
    {
        int tmp =  beginOB > 1 ? beginOB - 1 : 1;

        if(beginOB == 1) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + tmp + ")'>" + icon + "</a>";
        }
		/*/
		int tmp = currentPage > 1 ? currentPage - 1 : 1;
        if(currentPage == 1) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + tmp + ")'>" + icon + "</a>";
        }
		/*/
    }

    /**
    * 다음 블록의 첫 페이지를 구한다
    * <p>
    * @param icon 화면에 표시될 아이콘(텍스트) 문자열
    */
    public String getNext(String icon)
    {
        int tmp = endOB < pageCount ? endOB + 1 : beginOB;
        if(endOB == pageCount) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + tmp + ")'>" + icon + "</a>";
        }
		/*/
		int tmp = currentPage < pageCount ? currentPage + 1 : currentPage;
        if(currentPage == pageCount) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + tmp + ")'>" + icon + "</a>";
        }
		/*/
    }

    /**
    * 마지막 페이지를 구한다
    * <p>
    * @param icon 화면에 표시될 아이콘(텍스트) 문자열
    */
    public String getLast(String icon)
    {
        if(endOB == pageCount) {
            return icon;
        } else {
            return "<a class='paging' href='javascript:move(" + pageCount + ")'>" + icon + "</a>";
        }
    }

    /**
    *
    */
    public String getPages() {
        String pageStr = "";

        for(int i = getBeginOB(); i <= getEndOB(); i++) {
            if(currentPage == i) {
                pageStr += "<b><font color='red'>" + i + "</font></b>";
            } else {
                pageStr += "<a class='paging' href='javascript:move(" + i + ")'>[" + i + "]</a>";
            }
        }

        return pageStr;
    }

	public String getIndi(){
		return getFirst("[처음]")+getPrev("[이전]")+getPages()+getNext("[다음]")+getLast("[마지막]");
	}

	public String getSimpleIndi(){
		return getFirst("[<<]")+getPrev("[<]")+getPages()+getNext("[>]")+getLast("[>>]");
	}

	public String getIndi(String first,String priview,String next,String last){
		return getFirst(first)+getPrev(priview)+getPages()+getNext(next)+getLast(last);
	}
}