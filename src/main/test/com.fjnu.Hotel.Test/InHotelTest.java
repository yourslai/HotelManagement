package com.fjnu.Hotel.Test;

import com.fjnu.Hotel.IData;
import com.fjnu.Hotel.InHotel;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.*;

public class InHotelTest {
    IData iData=null;
    InHotel ih=null;
//	@Before
/*	public void setup()throws Exception{
		iData=mockery.mock(IData.class);
		ih=new InHotel(iData);
		mockery.checking(new Expectations(){{
			oneOf(iData).in_Out_Room(901,"Marry");will(returnValue(
					"Marry入住房间"));
		}});
	}*/

    @Test
    public void testInSuccess() {
        //	assertEquals("Marry入住房间",ih.in(901, "Marry"));
        iData=EasyMock.createMock(IData.class);
        EasyMock.expect(iData.in_Out_Room(901, "Marry"))
                .andReturn("Marry入住房间");
        EasyMock.replay(iData);
        InHotel ih=new InHotel(iData);
        assertEquals("Marry入住房间",ih.in(901, "Marry"));
        EasyMock.verify(iData);
    }
    @Test
    public void testInFailure() {
        iData=EasyMock.createMock(IData.class);
        EasyMock.expect(iData.in_Out_Room(901, "Marry"))
                .andReturn("房间已有人入住");
        EasyMock.replay(iData);
        InHotel ih=new InHotel(iData);
        assertEquals("房间已有人入住",ih.in(901, "Marry"));
        EasyMock.verify(iData);
    }
    @Test
    public void testInInvalid() {
        iData=EasyMock.createMock(IData.class);
        EasyMock.expect(iData.in_Out_Room(9001, "Marry"))
                .andReturn(" ");
        EasyMock.replay(iData);
        InHotel ih=new InHotel(iData);
        assertEquals("查无此房间",ih.in(9001, "Marry"));
        EasyMock.verify(iData);
    }


}