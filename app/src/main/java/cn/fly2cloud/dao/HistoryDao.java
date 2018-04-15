package cn.fly2cloud.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cn.fly2cloud.db.HistoryDBHelper;
import cn.fly2cloud.model.Trace;

/**
 * Created by Administrator on 2018/4/15.
 */

public class HistoryDao {
    private Context mContext;
    private HistoryDBHelper mHelper;
    private SQLiteDatabase mDatabase;

    public HistoryDao(Context context) {
        this.mContext=context;
        if(this.mHelper==null){
            this.mHelper=new HistoryDBHelper(context);
        }
        init();
    }

    public Trace findByPosition(int position){
        Trace trace = new Trace("0","0","0","0");
        Cursor cursor = null;
        String pos = String.valueOf(position+1);
        if(mDatabase!=null){
            cursor = mDatabase.query(HistoryDBHelper.TABLE_NAME,new String[]{"Time","Name","imageAdd","Descri"},
                    "Id=?",new String[]{pos},null,null,null);
        }
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            trace.setTime(cursor.getString(0));
            trace.setName(cursor.getString(1));
            trace.setImageAdd(cursor.getString(2));
            trace.setDescri(cursor.getString(3));
        }
        cursor.close();
        return trace;
    }

    private void init(){
       mDatabase =  mHelper.getWritableDatabase();
       mDatabase.beginTransaction();
       mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1725-1975','打孔卡(Punch cards)','PunchCard.jpeg','最早的已知数据存储形式是打卡，由Basile Bouchon于1725年创建。打卡是用于存储图案而不是实际数据的穿孔纸张循环。实际上，打孔卡被用于存储各种机器的设置，并具有960比特的容量。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1846-1990s','穿孔纸带(Punched tape)','Punchedtape.jpeg','打孔胶带于1846年由传真机Alexander Bain的发明人首次使用。 打孔胶带由一个长条形纸条组成，其中打孔以存储数据。 条上的每一行代表一个字符，但通过创建扇形折叠可以存储更多的数据。折叠时，打孔胶带可以存储多达几十千字节的数据 - 比打卡多得多的数据。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1928','磁带(Magnetic Tape)','Magnetictape.jpeg','德国工程师Fritz Pfleumer于1928年获得了磁带专利。他将他的发明基于Vlademar Poulsen的磁线。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1932','磁鼓(Magnetic Drum)','MagneticDrume.jpg','奥地利创新者G.Taushek于1932年发明了磁鼓。他将他的发明基于Fritz Pfleumer的发现。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1946','威廉姆斯管(Williams Tube)','WilliamsTube.jpg','Fredrick C. Williams教授和他的同事在位于英国的曼彻斯特大学开发了第一个随机存取计算机存储器。 他使用一系列静电阴极射线管进行数字存储。 1948年成功实现了1024位信息的存储。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1948','选数管(Selectron Tube)','SelectronTube.jpg','1948年，美国无线电公司（RCA）开发了Selectron电子管，这是早期的计算机内存形式，类似于Williams-Kilburn设计。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1949','延迟线存储器(Delay Line Memory)','DelayLineMemory.jpg','延迟线存储器包括将信息模式赋予延迟路径。 如果延迟路径的末端通过放大和时间电路连接到起点，则形成闭环以允许信息的再循环。 延迟线记忆功能类似于从目录输入重复的电话号码，直到个人拨打该号码为止。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1950s','磁芯(Magnetic Core)','MagneticCore.jpg','磁芯存储器也称为铁氧体磁芯存储器，它使用由陶瓷制成的小型磁环来存储极性信息和其包含的磁场。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1956','硬盘(Hard Disk)','HardDisk.jpg','硬盘实现旋转盘片，其存储并从平坦的磁性表面获取数位信息。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1963','音乐磁带(Music Tape)','MusicTape.jpg','飞利浦于1963年推出了紧凑型音频盒式磁带。飞利浦原本打算为听写机器使用音频盒式磁带; 然而，它成为分发预录音乐的流行方法。 1979年，索尼的随身听帮助改变了使用广泛使用和流行的录音带。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1966','动态随机存取存储器(DRAM)','DRAM.jpg','1966年，Robert H. Dennard发明了DRAM单元。 动态随机存取存储器技术（DRAM），或包含一个晶体管的存储单元。 DRAM单元将比特信息作为电荷存储在电路中。 DRAM单元增加了整体存储密度。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1968','磁扭线存储器(Twistor Memory)','TwistorMemory.jpg','贝尔实验室通过在传导电流的导线周围缠绕磁带开发了Twistor存储器。 贝尔实验室在1968年至1970年代中期之间使用了Twistor磁带，然后它被RAM芯片完全取代。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1970','磁泡存储器(Bubble Memory)','BubbleMemory.jpg','1970年，Andrew Bobeck发明了Bubble Memory，这是一种薄磁性薄膜，用于在小磁化区域存储一点数据，看起来像气泡。 Twistor存储器的开发使他能够创建Bubble Memory。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1971','8英寸软盘(8\" Floppy)','8Floppy.jpg','IBM开始开发适合将微码加载到System / 370主机中的廉价系统。 结果，8英寸软盘出现了。 软磁盘是一种由塑料包裹的磁性薄膜制成的便携式存储设备，使存储数据变得更简单快捷。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1975','5.25英寸软盘(5.25\" Floppy)','5Floppy.jpg','1976年，Allan Shugart开发了一种5.25英寸的软盘.Sugart开发了一种更小的软盘，因为8英寸软盘对于标准台式计算机来说太大了。 5.25英寸软盘的存储容量为110千字节。 5.25英寸的软盘是其前代产品的更便宜和更快的替代产品。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1980','光盘(CD)','CD.jpg','在20世纪60年代，詹姆斯·T·罗素想到用光来录制和重放音乐。 因此，他在1970年发明了光学数字电视录放电视; 然而，没有人采取他的发明。 1975年，飞利浦代表在他的实验室拜访了罗素。 他们向Russel支付了数百万美元，用于开发光盘（CD）。 1980年，罗素完成了这个项目，并将它交给了索尼。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1981','3.5英寸软盘(3.5\" Floppy)','3Floppy.jpg','3.5英寸软盘与其前辈相比具有明显的优势。 它有一个坚硬的金属盖，使其更难以破坏内部的磁性膜。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1984','光盘只读内存(CD Rom)','CDRom.jpg','CD-ROM也称为光盘只读存储器，使用与音频光盘相同的物理格式来存储数字数据。 CD-ROM将数字数据的微小凹坑编码到塑料盘的下表面，这允许存储大量的数据。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1987','数字录音带(Digital Audio Tape)','DAT.jpg','1987年，索尼推出了数字音频磁带（DAT），一种信号记录和回放机器。 它与表面上的音频盒式磁带相似，其中4毫米磁带被封装在保护壳中。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1989','数字数据存储(Digital Data Storage)','DDS.jpg','1989年，索尼和惠普推出了数字数据存储（DDS）格式来存储和备份磁带上的计算机数据。 数字数据存储（DDS）格式是从数字音频磁带（DAT）技术发展而来的。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1990','磁光盘(Magneto-Optical disc)','MOD.jpg','1990年，磁光盘出现在信息技术领域。这种光盘格式结合了光学和磁性技术来存储和检索数字数据。 需要一个特殊的磁光驱动器来检索存储在这些3.5到5.25英寸光盘上的数据。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1992','迷你光碟(MiniDisc)','MiniDisc.jpg','MiniDisc存储任何类型的数字数据; 然而，它主要用于音频。 索尼在1991年推出了MiniDisc技术。1992年，菲利普推出了数字小型盒式系统（DCC）。 MiniDisc打算在1996年最终淘汰之前取代录音带。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1993','数字线性带(Digital Linear Tape)','DLT.jpg','数字设备公司发明了数字线性磁带（DLT），它是用于计算机存储的磁带技术的替代品。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1994','闪存卡(Compact Flash)','CompactFlash.jpg','CompactFlash（CF），也称为“闪存驱动器”，使用封闭式光盘中的闪存来保存数字数据。 CF设备用于数码相机和计算机中以存储数字信息。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1994','极碟驱动器(Zip)','Zip.jpg','Zip驱动器于1994年开始普遍用于存储数字文件。 这是Iomega推出的可移动磁盘存储系统。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1995','数字化视频光盘(DVD)','DVD.jpg','DVD成为下一代数字光盘存储。 DVD是替代光盘的更大，更快的产品，用于存储多媒体数据。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1995','SM卡(SmartMedia)','SmartMedia.jpg','东芝于1995年夏季发布了闪存卡SmartMedia，以与MiniCard和SanDisk竞争。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1995','可擦写光盘(CD-RW)','CDrw.jpg','光盘可重写光盘是CD-ROM的可重写版本，允许用户通过以前的数据记录数字数据。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1997','多媒体记忆卡(Multimedia Card)','Multimediacard.jpg','多媒体卡（MMC）使用闪存卡标准来容纳数字数据。 它由Siemens和SanDisk于1997年推出。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('1999','微硬盘(Microdrive)','Microdrive.jpg','USB闪存驱动器使用NAND型闪存来存储数字数据。 USB闪存驱动器插入标准计算机上的USP接口。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('2000','SD卡(SD Card)','SDCard.jpg','安全数字（SD）闪存格式融合了DRM加密功能，可实现更快的文件传输。 标准SD卡的尺寸为32毫米×32毫米×2.1毫米。 典型的SD卡存储便携式设备的数字媒体。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('2002','XD图像卡(xD-Picture Card)','Xdpicturecard.jpg','奥林巴斯和富士胶片于2002年推出了xD-Picture Card卡，专门用于奥林巴斯和富士数码相机。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('2003','蓝光(Blu Ray)','Bluray.jpg','蓝光是用于存储高清视频（HD）和高密度存储的下一代光盘格式。 蓝光获得了蓝色激光的名称，可以存储比标准DVD更多的数据。 其竞争对手是HD-DVD。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('2003','高清光盘(HD-DVD)','HDDVD.jpg','高密度数字多功能光盘（HD-DVD）是一种数字光学媒体格式，使用与蓝光光盘相同的光盘尺寸。 它由东芝，NEC和三洋推广。')");
        mDatabase.execSQL("insert into " + HistoryDBHelper.TABLE_NAME + "(Time,Name,imageAdd,Descri) values ('2000s','全息数据存储(Holographic Data Storage)','Holographic.jpg','计算机内存的未来在于全息技术。 全息存储器可以在晶体和光聚合物中高密度地存储数字数据。 全息存储器的优点在于其存储大量记录介质的能力，而不仅仅是在光盘表面上。 此外，它还可以实现3D方面，允许出现称为布拉格体积的现象。')");
        mDatabase.setTransactionSuccessful();
    }

}
