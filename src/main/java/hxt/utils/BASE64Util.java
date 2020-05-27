package hxt.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by hxt
 * Date 2020/5/28 7:07 上午
 * Description BASE64编码工具类
 */
public class BASE64Util {
    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * 编码
     *
     * @param text
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encode(String text) throws UnsupportedEncodingException {
        return customEncode(text, DEFAULT_ENCODING);
    }

    /**
     * 编码 自定义编码格式
     *
     * @param text
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String customEncode(String text, String encoding) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(text.getBytes(encoding));
    }

    /**
     * 解码
     *
     * @param text
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decode(String text) throws UnsupportedEncodingException {
        return customDecode(text, DEFAULT_ENCODING);
    }

    /**
     * 解码 自定义编码格式
     *
     * @param text
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String customDecode(String text, String encoding) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(text), encoding);
    }
}
