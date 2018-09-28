package net.dark_roleplay.medieval.common;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.fml.relauncher.Side;

public class References {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "1.12.2-0.3.0";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.13)";
	public static final String DEPENDECIES = "required-after:drpcore@[0.4.3,);before:drpcmmaarg";
	public static final String UPDATECHECK = "https://dark-roleplay.net/files/versions/drpmedieval/drpmedieval-1.12.2.json";
	public static final List<String> AUTHORS = Arrays.asList("JTK222", "Rolfaal", "Kanno");
	public static final String CREDITS = "Lead Programmer: JTK222, Artists: Rolfaal & Kanno";
    public static final Logger LOGGER = LogManager.getLogger(References.MODID);

    public static final int MAARG_VERSION = 1;

    public static final boolean IS_DEV = true;

	public static CheckResult VERSION_STATUS;

	public static Side SIDE;
}