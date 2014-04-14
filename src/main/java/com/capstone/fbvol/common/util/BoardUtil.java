package com.capstone.fbvol.common.util;

import com.capstone.fbvol.common.util.text.StringUtil;
import com.capstone.fbvol.model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 게시판 관련 유틸 클래스
 *
 * @author 명준민
 * @date   2007. 05. 11
 * @desc   오라클 전용이며 페이징, 시작페이지, 마지막페이지 등을 구하는 유
 */
public class BoardUtil {

	private Logger logger = LogManager.getLogger(BoardUtil.class);

	private static BoardUtil boardUtil = new BoardUtil();

	private BoardUtil() { }

	public static BoardUtil getInstance() {
		return boardUtil;
	}

	/**
	 * 페이지 navigation - 텍스트 기반
	 * @param pageNo : 현재 페이지 번호
	 * @param countPerPage : 한 페이지에 보여줄 갯수
	 * @param totalNo : 전체 데이터 갯수
	 * @return
	 */
	private String getPpageNaviText(int pageNo, int countPerPage, int totalNo) {
		int endPage = this.getEndPage(pageNo, countPerPage, totalNo);

		int tmp   = (pageNo-1) % countPerPage;
		int spage = pageNo - tmp;

//		if(logger.isDebugEnabled()) {
//			logger.debug("■■■■■■■■■■■■■■■■■■■■ [pageNo]      : [" + pageNo + "]");
//			logger.debug("■■■■■■■■■■■■■■■■■■■■ [tmp]         : [" + tmp + "]");
//			logger.debug("■■■■■■■■■■■■■■■■■■■■ [spage]       : [" + spage + "]");
//			logger.debug("■■■■■■■■■■■■■■■■■■■■ [endPage]     : [" + endPage + "]");
//		}
//
		StringBuffer sb = new StringBuffer();

		if(pageNo==1) {
			sb.append("<font color=gray>처음</a>&nbsp;&nbsp;");
		} else {
			sb.append("<a href='javascript:goPage(1);' style='link'>");
			sb.append("처음</a>&nbsp;&nbsp;");
		}


		//======================================================================
		//이전 10개
		//======================================================================
		if(spage-countPerPage>0) {
			sb.append("◀ <a href='javascript:goPage("+(spage-1)+");'>");
			sb.append("[이전 "+countPerPage+"개]</a>&nbsp;&nbsp;");
		} else {
			sb.append("<font color=gray>◀ [이전 "+countPerPage+"개]</font>&nbsp;&nbsp;");
		}

		//======================================================================
		//페이지 번호 나열
		//======================================================================
		for (int i=spage; i < spage+countPerPage; i++) {

			//범위를 벗어나면 loop 종료
			if( i > endPage){
				break;
			}

			if(i==pageNo) {
				sb.append("[<b>" + (i) + "</b>]");
			} else {
				sb.append("<a href='javascript:goPage("+i+");' style='link'>"+i+"</a>");
			}

			if(i!=endPage) sb.append("</a>&nbsp;&nbsp;");
		} //end of for


		//======================================================================
		//다음 10개 부분 표현
		//======================================================================
		sb.append("&nbsp;&nbsp;");

		if(spage+countPerPage <= endPage) {
			sb.append("<a href='javascript:goPage("+(spage+countPerPage)+");'>");
			sb.append("[다음 "+countPerPage+"개]</a> ▶");
		} else {
			sb.append("<font color=gray>[다음 "+countPerPage+"개] ▶");
		}


		//======================================================================
		//끝으로
		//======================================================================
		sb.append("&nbsp;&nbsp;");

		if(pageNo>=endPage) {
			sb.append("<font color=gray>끝으로</font>");
		} else {
			sb.append("<a href='javascript:goPage("+endPage+");'>끝으로</a>");
		}

		return sb.toString();
	}

	/**
	 * 페이지 navigation
	 * @param pageNo : 현재 페이지 번호
	 * @param countPerPage : 한 페이지에 보여줄 갯수
	 * @param totalNo : 전체 데이터 갯수
	 * @return
	 */
	private String getPpageNavi(int pageNo, int countPerPage, int totalNo) {
		int endPage = this.getEndPage(pageNo, countPerPage, totalNo);

		int tmp   = (pageNo-1) % countPerPage;
		int spage = pageNo - tmp;

		StringBuffer sb = new StringBuffer();

		if(pageNo==1) {
			sb.append("<img src='{root}/images/arrow_start.gif' align=absmiddle>&nbsp;");
		} else {
			sb.append("<a href='javascript:goPage(1);' style='link'>");
			sb.append("<img src='{root}/images/arrow_start.gif' align=absmiddle></a>&nbsp;");
		}


		//======================================================================
		//이전 10개
		//======================================================================
		if(spage-countPerPage>0) {
			sb.append("<a href='javascript:goPage("+(spage-1)+");'>");
			sb.append("<img src='{root}/images/arrow_prev.gif' align=absmiddle></a>&nbsp;&nbsp;&nbsp;&nbsp;");
		} else {
			sb.append("<img src='{root}/images/arrow_prev.gif' align=absmiddle>&nbsp;&nbsp;&nbsp;&nbsp;");
		}

		//======================================================================
		//페이지 번호 나열
		//======================================================================
		for (int i=spage; i < spage+countPerPage; i++) {

			//범위를 벗어나면 loop 종료
			if( i > endPage){
				break;
			}

			if(i==pageNo) {
				sb.append("<b><font color='#FF6600'>" + i + "</font></b>");
			} else {
				sb.append("<a href='javascript:goPage("+i+");' style='link'><font color='#666666'>"+i+"</font></a>");
			}

			if(i==endPage) {

			} else {
				if(i==spage) {
					sb.append("&nbsp; | &nbsp;");
				} else if(i!=(endPage)) {
					sb.append("&nbsp; | ");
				}
			}

//			if(i!=endPage) sb.append("&nbsp;&nbsp;");
		} //end of for


		//======================================================================
		//다음 10개 부분 표현
		//======================================================================
		sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");

		if(spage+countPerPage <= endPage) {
			sb.append("<a href='javascript:goPage("+(spage+countPerPage)+");'>");
			sb.append("<img src='{root}/images/arrow_next.gif' border='0' align='absmiddle'></a>");
		} else {
			sb.append("<img src='{root}/images/arrow_next.gif' border='0' align='absmiddle'>");
		}


		//======================================================================
		//끝으로
		//======================================================================
		sb.append("&nbsp;");

		if(pageNo>=endPage) {
			sb.append("<img src='{root}/images/arrow_end.gif' border='0' align='absmiddle'>");
		} else {
			sb.append("<a href='javascript:goPage("+endPage+");'><img src='{root}/images/arrow_end.gif' border='0' align='absmiddle'></a>");
		}

		return sb.toString();
	}

	/**
	 * LIMIT 함수의 시작 번호 구하기
	 * @param pageNo : 현재 페이지 번호
	 * @param countPerPage : 한 페이지에 보여줄 데이터 갯수
	 * @return
	 */
	public int getStartNo(int pageNo, int countPerPage) {

    	return (pageNo - 1) * countPerPage;
    }

	/**
	 * 끝 페이지 구하기
	 * @param pageNo : 현재 페이지 번호
	 * @param countPerPage : 한 페이지에 보여줄 데이터 갯수
	 * @param totalNo : 전체 데이터 갯
	 * @return
	 */
	private int getEndPage(int pageNo, int countPerPage, int totalNo) {
        int extra = totalNo % countPerPage;

        if ( extra > 0 ){
            return (totalNo - extra )/countPerPage + 1;
        } else {
            return totalNo/countPerPage;
        }
    }

    /**
     * 목록성 화면을 구성하는 필요한 기본정보를 세팅한다.
     * @author 명준민
     * @param tableName : 조회에 사용될 DB 테이블 이름
     * @param param : where절 및 각종 정보를 담은 Entity를 입력해주세요.
     * @param sc    : 서블릿 정보를 담고 있는 ServletContext
     * @return param : 파라메터로 받은 Entity에 값을 더하여 다시 리턴
     * @date   2007. 05. 11
     */
    public Entity getBoardInfo(Entity param, int totalNo)  throws Exception {

//    	int pageNo       = param.getInt("pageNo")==0 ? 1 : param.getInt("pageNo");
//    	int countPerPage = param.getInt("countPerPage")==0 ? 10 : param.getInt("countPerPage");
//    	int startNo      = this.getStartNo(pageNo, countPerPage);
//    	int brdNo        = totalNo; //게시물 일련번호

        int pageNo       = Integer.parseInt(StringUtil.nvl(param.getString("pageNo"), "1"));
        int countPerPage = Integer.parseInt(StringUtil.nvl(param.getString("countPerPage"), "10"));
        int startNo      = this.getStartNo(pageNo, countPerPage);
        int brdNo        = totalNo; //게시물 일련번호

        //===========================================================
        //페이징의 마지막 페이지 번호
        //===========================================================
        int endPage      = 0;
        int tmp1 = totalNo % countPerPage;

        if( tmp1>0 ) {
        	endPage = (totalNo - tmp1 ) / countPerPage + 1;
        } else {
        	endPage = totalNo/countPerPage;
        }



        if(pageNo>1) {
        	brdNo = totalNo - (countPerPage * (pageNo-1));
        }


        //Velocity에서 게시판 순번을 뿌려주는데 다소 문제가 있으므로 여기에서 처리하여 내려준다.
        String bSeq = "<script>var bSeq="+brdNo+";</script> ";


        String pageNavi  = this.getPpageNavi(
                pageNo,
                countPerPage,
                totalNo
                );

        String pageNaviText  = this.getPpageNaviText(
        		pageNo,
        		countPerPage,
        		totalNo
        );

        if(logger.isDebugEnabled()) {
        	logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        	logger.debug("[totalNo]        : " + totalNo);
        	logger.debug("[pageNo]         : " + pageNo);
        	logger.debug("[countPerPage]   : " + countPerPage);
        	logger.debug("[startNo]        : " + startNo);
        	logger.debug("[brdNo]          : " + brdNo);
        	logger.debug("[endPage]        : " + endPage);
        	logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        }

        //생성된 정보를 Entity에 담는다.
        param.setValue("totalNo", 		totalNo			);
        param.setValue("pageNo", 	    pageNo		    );
        param.setValue("countPerPage", 	countPerPage	);
        param.setValue("startNo", 		startNo			);
        param.setValue("brdNo", 		brdNo		    );
        param.setValue("bSeq", 			bSeq			);
        param.setValue("endPage", 		endPage			);
        param.setValue("pageNavi", 		pageNavi		);
        param.setValue("pageNaviText", 	pageNaviText	);

    	return param;
    }

//    /**
//     * 목록성 화면을 구성하는 필요한 기본정보를 세팅한다.
//     * JOIN 쿼리문의 경우 하나의 테이블명만으로는 전체갯수를 구하기 어려우므로
//     * 해당 SQLID를 통해 쿼리문을 가져와서 전체 갯수를 구하도록 한다.
//     * @author 명준민
//     * @param sqlId : DB에 등록된 쿼리문
//     * @param param : where절 및 각종 정보를 담은 Entity를 입력해주세요.
//     * @param sc    : 서블릿 정보를 담고 있는 ServletContext
//     * @return param : 파라메터로 받은 Entity에 값을 더하여 다시 리턴
//     * @date   2007. 05. 11
//     */
//    public Entity getBoardInfo2(
//    		String sqlId,
//    		Entity param,
//    		ServletContext sc) throws Exception {
//
//    	//전체 갯수를 구하기 위한 참조
//    	CommonService commonService = null;
//
//    	try {
//    		commonService= (CommonService)SpringBeanLoader.getInstance(sc).getBean("commonService");
//    	} catch (Exception e) {
//    		logger.error("commonService 객체를 참조하지 못했습니다.");
//    		e.printStackTrace();
//    	}
//
//    	int totalNo      = commonService.getTotalNoBySqlId(sqlId, param.getString("where"));
//    	int pageNo       = param.getInt("pageNo")==0 ? 1 : param.getInt("pageNo");
//    	int countPerPage = param.getInt("countPerPage")==0 ? 10 : param.getInt("countPerPage");
//    	int startNo      = this.getStartNo(pageNo, countPerPage);
//    	int boardSeq     = totalNo; //게시물 일련번호
//
//    	if(pageNo>1) {
//    		boardSeq = totalNo - (countPerPage * (pageNo-1));
//    	}
//
//    	//Velocity에서 게시판 순번을 뿌려주는데 다소 문제가 있으므로 여기에서 처리하여 내려준다.
//    	String bSeq = "<script>var bSeq="+boardSeq+";</script> ";
//
//
//    	String pageNavi  = this.getPpageNavi(
//    			pageNo,
//    			countPerPage,
//    			totalNo
//    	);
//
//    	if(logger.isDebugEnabled()) {
//    		logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//    		logger.debug("[totalNo]        : " + totalNo);
//    		logger.debug("[pageNo]         : " + pageNo);
//    		logger.debug("[countPerPage]   : " + countPerPage);
//    		logger.debug("[startNo]        : " + startNo);
//    		logger.debug("[boardSeq]       : " + boardSeq);
//    		logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//    	}
//
//    	//생성된 정보를 Entity에 담는다.
//    	param.setValue("totalNo", 		totalNo			);
//    	param.setValue("pageNo", 	    pageNo		    );
//    	param.setValue("countPerPage", 	countPerPage	);
//    	param.setValue("startNo", 		startNo			);
//    	param.setValue("boardSeq", 		boardSeq		);
//    	param.setValue("bSeq", 			bSeq			);
//    	param.setValue("pageNavi", 		pageNavi		);
//
//    	return param;
//    }
//
//    public Entity getBoardInfo2(
//    		String sqlId,
//    		Entity param,
//    		ServletContext sc,
//    		Object[] obj) throws Exception {
//
//    	//전체 갯수를 구하기 위한 참조
//    	CommonService commonService = null;
//
//    	try {
//    		commonService= (CommonService)SpringBeanLoader.getInstance(sc).getBean("commonService");
//    	} catch (Exception e) {
//    		logger.error("commonService 객체를 참조하지 못했습니다.");
//    		e.printStackTrace();
//    	}
//
//    	int totalNo      = commonService.getTotalNoBySqlId(sqlId, param.getString("where"), obj);
//    	int pageNo       = param.getInt("pageNo")==0 ? 1 : param.getInt("pageNo");
//    	int countPerPage = param.getInt("countPerPage")==0 ? 10 : param.getInt("countPerPage");
//    	int startNo      = this.getStartNo(pageNo, countPerPage);
//    	int boardSeq     = totalNo; //게시물 일련번호
//
//    	if(pageNo>1) {
//    		boardSeq = totalNo - (countPerPage * (pageNo-1));
//    	}
//
//    	//Velocity에서 게시판 순번을 뿌려주는데 다소 문제가 있으므로 여기에서 처리하여 내려준다.
//    	String bSeq = "<script>var bSeq="+boardSeq+";</script> ";
//
//
//    	String pageNavi  = this.getPpageNavi(
//    			pageNo,
//    			countPerPage,
//    			totalNo
//    	);
//
//    	if(logger.isDebugEnabled()) {
//    		logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//    		logger.debug("[totalNo]        : " + totalNo);
//    		logger.debug("[pageNo]         : " + pageNo);
//    		logger.debug("[countPerPage]   : " + countPerPage);
//    		logger.debug("[startNo]        : " + startNo);
//    		logger.debug("[boardSeq]       : " + boardSeq);
//    		logger.debug("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//    	}
//
//    	//생성된 정보를 Entity에 담는다.
//    	param.setValue("totalNo", 		totalNo			);
//    	param.setValue("pageNo", 	    pageNo		    );
//    	param.setValue("countPerPage", 	countPerPage	);
//    	param.setValue("startNo", 		startNo			);
//    	param.setValue("boardSeq", 		boardSeq		);
//    	param.setValue("bSeq", 			bSeq			);
//    	param.setValue("pageNavi", 		pageNavi		);
//
//    	return param;
//    }

    /**
     * 목록성 화면 출력을 query 문 생성
     * @author Administrator
     * @param sql : 비즈니스로직을 담은 쿼리문
     * @param pageNo : 현재 페이지 번호
     * @param countPerPage : 한 페이지에 보여줄 데이터 갯수
     * @return query : 조합된 쿼리문
     * @date   2007. 05. 11
     */
    public String getPagingQuery(String sql, int pageNo, int countPerPage) {

    	String prefix = "SELECT * FROM ( " +
    	                "	SELECT LAST_VALUE(ROWNUM) OVER() AS LASTNUM, A.*, ROWNUM rn " +
    	                "     FROM ( ";

    	String suffix = "          ) A " +
    	                "   )          " +
    	                " WHERE rn BETWEEN ("+ pageNo +"-1) * "+ countPerPage +"+1 " +
    	                "              AND "+ pageNo +" * "+ countPerPage +" ";


    	sql = prefix + sql + suffix;

    	return sql;
    }


	/**
     * content문에서 줄바꿈 문자(Enter key)를 HTML문의 &lt;br&gt; Tag 로 바꿔주는 함수
	 *
	 * @param content 줄바꿈 문자(Enter key)가 섞인 문자열
	 * @return &lt;br&gt; Tag 이 섞인 html문자열
	 * @since 1.0
	 */
    public static String htmlToBr(String content)
    {
        int length = content.length();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < length; ++i)
        {
            String comp = content.substring(i, i+1);
            if ("\r".compareTo(comp) == 0)
            {
                comp = content.substring(++i, i+1);
                if ("\n".compareTo(comp) == 0)
                    buffer.append("<BR>\r");
                else
                    buffer.append("\r");
            }
            else if ("\n".compareTo(comp) == 0)
            {
                buffer.append("<BR>\r");
            }
            buffer.append(comp);
        }
        return buffer.toString();
    }


	/**
     * content문에서 Single Quota(')를 ('')로 변경한다.
	 *
	 * @param content Single Quota(')가 섞인 문자열
	 * @return ('')로 변경된 문자열
	 * @since 1.0
	 */
	public static String htmlToQuota(String content)
    {
        int length = content.length();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < length; ++i)
        {
            String comp = content.substring(i, i+1);

            if ("'".compareTo(comp) == 0)
            {
                comp = content.substring(++i, i+1);
                buffer.append("''");
            }

            buffer.append(comp);
        }
        return buffer.toString();
    }

	/**
     * content문에서 줄바꿈 문자(Enter key)를 HTML문의 &lt;br&gt; + tab 으로 바꿔주는 함수
	 *
	 * @param content 줄바꿈 문자(Enter key)가 섞인 문자열
	 * @return "&lt;br&gt; + tab"이 섞인 html문자열
	 * @since 1.0
	 */
    public static String htmlToBrTab(String content)
    {
        int length = content.length();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < length; ++i)
        {
            String comp = content.substring(i, i+1);
            if ("\r".compareTo(comp) == 0)
            {
                comp = content.substring(++i, i+1);
                if ("\n".compareTo(comp) == 0)
                    buffer.append("<BR>\r&nbsp;&nbsp;&nbsp;&nbsp;");
                else
                    buffer.append("\r&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            else if ("\n".compareTo(comp) == 0)
            {
                buffer.append("<BR>\r&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            buffer.append(comp);
        }
        return buffer.toString();
    }

	/**
     * content문에서 줄바꿈 문자(Enter key)를 HTML문의 &lt;br&gt; Tag 로 바꿔주는 함수
	 *
	 * @param content 줄바꿈 문자(Enter key)가 섞인 문자열
	 * @return &lt;br&gt; Tag 이 섞인 html문자열
	 * @since 1.0
	 */
	public static String htmlToView(String content)
    {
		/*
        int length = content.length();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < length; ++i)
        {
            String comp = content.substring(i, i+1);
            if("\n".compareTo(comp) == 0){
            	comp = content.substring(++i, i+1);
            	buffer.append("<BR>\n");
            }
            else if("\t".compareTo(comp) == 0){
            	comp = content.substring(++i, i+1);
            	buffer.append("&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            else if(" ".compareTo(comp) == 0){
            	comp = content.substring(++i, i+1);
            	buffer.append("&nbsp;");
            }
            buffer.append(comp);
        }
        return buffer.toString();
		*/
		String retVal = content;
		retVal = retVal.replaceAll("\n", "<br>\n");
		retVal = retVal.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		retVal = retVal.replaceAll(" ", "&nbsp;");

		return retVal;
    }

}
