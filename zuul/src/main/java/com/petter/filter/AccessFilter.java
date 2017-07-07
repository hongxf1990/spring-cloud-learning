package com.petter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hongxf
 * @since 2017-07-07 15:05
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = Logger.getLogger(AccessFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
     * 这里总是生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            //zuul过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            //设置返回错误码
            ctx.setResponseStatusCode(401);

            //也可以通过ctx.setResponseBody(body)对返回body内容进行编辑
            return null;
        }
        logger.info("access token ok");

        return null;
    }
}
