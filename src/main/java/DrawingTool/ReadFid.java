package DrawingTool;

import sun.misc.resources.Messages;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *读取fid文件
 */
public class ReadFid {

public static float[][] readFidSpecFile(final String filePathName, final int pointNum, final int traceNum, final ByteOrder byteOrder, final String nc) {
        ByteBuffer data = null;
        FileInputStream fileInputStream = null;
        try {
        fileInputStream = new FileInputStream(filePathName);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        data = ByteBuffer.wrap(buffer);
        data.order(byteOrder);
        } catch (IOException e) {
                e.printStackTrace();
        //log.error(NLS.bind(Messages.In_readFileFailed, filePathName));
        return null;
        }
        finally {
                if (fileInputStream != null) {
                         try {
                                fileInputStream.close();
                         }
                        catch (IOException e) {
                                  e.printStackTrace();
                                                }
                }
        }

        float[][] outData = new float[traceNum][pointNum];
        for (int i = 0; i < traceNum; i++) {
        for (int j = 0; j < pointNum; j++) {
        try {
        // 此步非常耗时，谨记！ outData[i][j] = Float.valueOf(String.valueOf(data.getInt()));
        outData[i][j] = data.getInt();
        //System.out.println(Float.valueOf(String.valueOf(data.getInt())));
        if(!nc.isEmpty()){
        if(Integer.valueOf(nc) < 0){                          //绝对值
        outData[i][j] = outData[i][j] / (float)Math.pow(2, Math.abs(Integer.parseInt(nc)));
                 }

        if(Integer.valueOf(nc) > 0){
        outData[i][j] = outData[i][j] * (float)Math.pow(2, Math.abs(Integer.parseInt(nc)));
                         }
                }
        } catch (BufferUnderflowException exception) { // new出来的outData>源文件大小
                exception.printStackTrace();
                System.out.println("new出来的outData>源文件大小");
        //String message = NLS.bind(Messages.In_inconsistentWithParams, filePathName);
        //log.error(message);
        //IoLog.getInstance().append(message);
        //return null;
        }
        }
        }

        // 判断数据是否全部读取
        if (data.hasRemaining()) { // new出来的outData<原文件大小
                System.out.println("new出来的outData<原文件大小");
        //String message = NLS.bind(Messages.In_inconsistentWithParams, filePathName);
        //log.error(message);
        //IoLog.getInstance().append(message);
        //return null;
        }

        return outData;
        }
}
