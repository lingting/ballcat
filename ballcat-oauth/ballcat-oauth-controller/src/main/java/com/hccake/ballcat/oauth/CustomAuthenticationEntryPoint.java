package com.hccake.ballcat.oauth;

import com.hccake.ballcat.common.model.result.R;
import com.hccake.ballcat.common.model.result.SystemResultCode;
import com.hccake.ballcat.common.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Hccake
 * @version 1.0
 * @date 2019/9/25 22:04
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException e) throws IOException, ServletException {

		httpServletResponse.setHeader("Content-Type", MediaType.APPLICATION_JSON.toString());
		httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		R<Object> r = R.failed(SystemResultCode.UNAUTHORIZED, e.getMessage());
		httpServletResponse.getWriter().write(JsonUtils.toJson(r));
	}

}
