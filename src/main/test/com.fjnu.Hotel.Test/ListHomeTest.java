package com.fjnu.Hotel.Test;

import com.fjnu.Hotel.HotelConstant;
import com.fjnu.Hotel.IData;
import com.fjnu.Hotel.ListHome;
import org.easymock.EasyMock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class ListHomeTest {

    @Rule
    public final SystemOutRule systemOutRule=new SystemOutRule().enableLog();




    IData iData=null;



    @Test
    public void testSearch() {
        iData= EasyMock.createMock(IData.class);
        for(int i = 0; i< HotelConstant.NumOfFloor; i++){
            for(int j=0;j<HotelConstant.RoomsOfFloor;j++){
                EasyMock.expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);
            }
        }
        EasyMock.replay(iData);
        ListHome lh=new ListHome(iData);
        lh.search();
        String lineSeparator=System.getProperty("line.separator");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<HotelConstant.NumOfFloor;i++){
            for(int j=0;j<HotelConstant.RoomsOfFloor;j++){
                if(j+1<10){
                    sb.append(i+1+"0"+(j+1)+"\t");
                }else{
                    sb.append(i+1+""+(j+1)+"\t");
                }
            }

            sb.append(lineSeparator);
            for(int j=0;j<HotelConstant.RoomsOfFloor;j++){
                sb.append(HotelConstant.EMPTY+"\t");
            }
            sb.append(lineSeparator);
        }


        assertEquals(sb.toString(),systemOutRule.getLog());
        EasyMock.verify(iData);

    }
}