package com.robotca.ControlApp.Core;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Container for information about connections to specific Robots.
 *
 * Created by Michael Brunson on 1/23/16.
 */
public class RobotInfo implements Comparable<RobotInfo>, Savable {

    // Number of RobotInfos in storage
    private static int robotCount = 1;

    /** Bundle key for UUID */
    public static final String UUID_KEY = "UUID_KEY";
    /** Bundle key for robot name */
    public static final String ROBOT_NAME_KEY = "ROBOT_NAME_KEY";
    /** Bundle key for master URI */
    public static final String MASTER_URI_KEY = "MASTER_URI_KEY";
    /** Bundle key for joystick topic */
    public static final String JOYSTICK_TOPIC_KEY = "JOYSTICK_TOPIC_KEY";
    /** Bundle key for laser scan topic */
    public static final String LASER_SCAN_TOPIC_KEY = "LASER_SCAN_TOPIC_KEY";
    /** Bundle key for camera topic */
    public static final String CAMERA_TOPIC_KEY = "CAMERA_TOPIC_KEY";
    /** Bundle key for odometry topic */
    public static final String ODOMETRY_TOPIC_KEY = "ODOMETRY_TOPIC_KEY";
    /** Bundle key for sensorData topic */
    public static final String SENSOR_DATA_TOPIC_KEY = "SENSOR_DATA_TOPIC_KEY";
    /** Bundle key for car info topic */
    public static final String CAR_INFO_TOPIC_KEY = "CAR_INFO_TOPIC_KEY";
    /** Bundle key for enable kinect */
    public static final String ENABLE_KINECT_KEY = "ENABLE_KINECT_KEY";
    /** Bundle key for reverse laser scan */
    public static final String REVERSE_LASER_SCAN_KEY = "REVERSE_LASER_SCAN_KEY";
    /** Bundle key for invert x-axis */
    public static final String INVERT_X_KEY = "INVERT_X_KEY";
    /** Bundle key for invert x-axis */
    public static final String INVERT_Y_KEY = "INVERT_Y_KEY";
    /** Bundle key for invert x-axis */
    public static final String INVERT_ANGULAR_VELOCITY_KEY = "INVERT_ANGULAR_VELOCITY_KEY";


    // UUID for this RobotInfo
    private UUID id = UUID.randomUUID();

    // Name of this RobotInfo
    private String name;
    // Master URI of this RobotInfo
    private String masterUriString;

    // Topic names
    private String joystickTopic;
    private String cameraTopic;
    private String laserTopic;
    private String odometryTopic;
    private String sensorDataTopic;
    private String carInfoTopic;
    private boolean reverseLaserScan;
    private boolean enableKinect;
    private boolean invertX;
    private boolean invertY;
    private boolean invertAngularVelocity;

    @SuppressWarnings("unused")
    private static final String TAG = "RobotInfo";

    /**
     * Default Constructor.
     */
    public RobotInfo() {
        //id = UUID.randomUUID();
        name = "Car" + robotCount++;
        masterUriString = "http://localhost:11311";
        joystickTopic = "/pses_basis/command";
        cameraTopic = "/kinect2/qhd/image_color/compressed";
        laserTopic = "/scan";
        odometryTopic = "/odom";
        sensorDataTopic = "/pses_basis/sensor_data";
        carInfoTopic = "/pses_basis/car_info";
        reverseLaserScan = false;
        invertX = false;
        invertY = false;
        invertAngularVelocity = false;
    }

//    public RobotInfo(String mName, String mMasterUri) {
//        this.name = mName;
//        this.masterUriString = mMasterUri;
//    }

    /**
     * Creates a RobotInfo.
     * @param id UUID
     * @param name Name to show when displaying this RobotInfo
     * @param masterUriString Master URI for this RobotInfo
     * @param joystickTopic JoystickTopic name for this RobotInfo
     * @param laserTopic LaserTopic name for this RobotInfo
     * @param cameraTopic CameraTopic name for this RobotInfo
     */
    public RobotInfo(UUID id, String name, String masterUriString, String joystickTopic,
                     String laserTopic, String cameraTopic,
                     String odometryTopic, String sensorDataTopic, String carInfoTopic, boolean enableKinect, boolean reverseLaserScan,
                     boolean invertX, boolean invertY, boolean invertAngularVelocity) {
        this.id = id;
        this.name = name;
        this.masterUriString = masterUriString;
        this.joystickTopic = joystickTopic;
        this.laserTopic = laserTopic;
        this.cameraTopic = cameraTopic;
        this.odometryTopic = odometryTopic;
        this.sensorDataTopic = sensorDataTopic;
        this.carInfoTopic = carInfoTopic;
        this.reverseLaserScan = reverseLaserScan;
        this.enableKinect = enableKinect;
        this.invertX = invertX;
        this.invertY = invertY;
        this.invertAngularVelocity = invertAngularVelocity;
    }

    /**
     * @return UUID of this RobotInfo
     */
    public UUID getId(){return id;}

    /**
     * Sets the UUID of this RobotInfo
     * @param id The new UUID
     */
    public void setId(UUID id){ this.id = id; }

    /**
     * @return The CarInfoTopic name of this RobotInfo
     */
    public String getCarInfoTopic() {
        return carInfoTopic;
    }

    /**
     * Sets the CarInfoTopic for this RobotInfo.
     * @param carInfoTopic The new CarInfo
     */
    public void setCarInfoTopic(String carInfoTopic) {
        this.carInfoTopic = carInfoTopic;
    }
    
     /**
     * @return The SensorDataTopic name of this RobotInfo
     */
    public String getSensorDataTopic() {
        return sensorDataTopic;
    }

    /**
     * Sets the SensorDataTopic for this RobotInfo.
     * @param sensorDataTopic The new JoystickTopic
     */
    public void setSensorDataTopic(String sensorDataTopic) {
        this.sensorDataTopic = sensorDataTopic;
    }

    /**
     * @return The OdometryTopic name of this RobotInfo
     */
    public String getOdometryTopic() {
        return odometryTopic;
    }

    /**
     * Sets the OdometryTopic for this RobotInfo.
     * @param odometryTopic The new JoystickTopic
     */
    public void setOdometryTopic(String odometryTopic) {
        this.odometryTopic = odometryTopic;
    }

    /**
     * @return The JoystickTopic name of this RobotInfo
     */
    public String getJoystickTopic() {
        return joystickTopic;
    }

    /**
     * Sets the JoystickTopic for this RobotInfo.
     * @param joystickTopic The new JoystickTopic
     */
    public void setJoystickTopic(String joystickTopic) {
        this.joystickTopic = joystickTopic;
    }

    /**
     * @return The CameraTopic of this RobotInfo
     */
    public String getCameraTopic() {
        return cameraTopic;
    }

    /**
     * Sets the CameraTopic of this RobotInfo.
     * @param cameraTopic The new CameraTopic
     */
    public void setCameraTopic(String cameraTopic) {
        this.cameraTopic = cameraTopic;
    }

    /**
     * @return The LaserTopic of this RobotInfo
     */
    public String getLaserTopic() {
        return laserTopic;
    }

    /**
     * Sets the LaserTopic of this RobotInfo.
     * @param laserTopic The new LaserTopic
     */
    public void setLaserTopic(String laserTopic) {
        this.laserTopic = laserTopic;
    }

    /**
     * @return The Master URI of this RobotInfo
     */
    public String getMasterUri() {
        return masterUriString;
    }

    /**
     * Sets the Master URI of this RobotInfo.
     * @param mMasterUri The new Master URI
     */
    public void setMasterUri(String mMasterUri) {
        this.masterUriString = mMasterUri;
    }

    /**
     * @return The name of this RobotInfo
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this RobotInfo.
     * @param mName The new name
     */
    public void setName(String mName) {
        this.name = mName;
    }

    /**
     * @return The URI of Master URI of this RobotInfo
     */
    public URI getUri(){
        return URI.create(getMasterUri());
    }

    /**
     * @return If kinect should be enabled
     */
    public boolean isEnableKinect() {
        return enableKinect;
    }

    /**
     * @return If laser scan should be reversed
     */
    public boolean isReverseLaserScan() {
        return reverseLaserScan;
    }

    /**
     * Sets whether the laser scan should be reversed
     * @param reverseLaserScan Reverse if true, false otherwise
     */
    public void setReverseLaserScan(boolean reverseLaserScan) {
        this.reverseLaserScan = reverseLaserScan;
    }

    /**
     * @return If x-axis should be inverted
     */
    public boolean isInvertX() {
        return invertX;
    }

    /**
     * Sets whether to invert x-axis
     * @param invertX Invert if true, false otherwise
     */
    public void setInvertX(boolean invertX) {
        this.invertX = invertX;
    }

    /**
     * @return If y-axis should be inverted
     */
    public boolean isInvertY() {
        return invertY;
    }

    /**
     * Sets whether to invert y-axis
     * @param invertY Invert if true, false otherwise
     */
    public void setInvertY(boolean invertY) {
        this.invertY = invertY;
    }

    /**
     * @return If angular velocity should be inverted
     */
    public boolean isInvertAngularVelocity() {
        return invertAngularVelocity;
    }

    /**
     * Sets whether to invert angular velocity
     * @param invertAngularVelocity Invert if true, false otherwise
     */
    public void setInvertAngularVelocity(boolean invertAngularVelocity) {
        this.invertAngularVelocity = invertAngularVelocity;
    }

    /**
     * Compares this RobotInfo to another based on UUID.
     * @param another The other RobotInfo
     * @return The comparison result
     */
    @Override
    public int compareTo(@NonNull RobotInfo another) {

        if (this.getId() == null) {
            return -1;
        }

        if (another.getId() == null) {
            return 1;
        }

        return this.getId().compareTo(another.getId());
    }

    /**
     * Determines the correct value for robotCount.
     * @param list The list of loaded RobotInfos
     */
    public static void resolveRobotCount(List<RobotInfo> list)
    {
//        Log.d(TAG, "resolveRobotCount(" + list + ")");

        int max = 0;
        int val;

        for (RobotInfo info: list) {
            if (info.getName().startsWith("Car"))
            {
//                Log.d(TAG, "name = " + info.getName().substring(5));
                try {
                    val = Integer.parseInt(info.getName().substring(3));
                }
                catch (NumberFormatException e) {
                    val = -1;
                }

                if (val > max)
                    max = val;
            }
        }

        robotCount = max + 1;
    }

    /**
     * @return The robot count.
     */
    @SuppressWarnings("unused")
    static int getRobotCount()
    {
        return robotCount;
    }

    @Override
    public void load(@NonNull Bundle bundle) {
        id = UUID.fromString(bundle.getString(UUID_KEY, UUID.randomUUID().toString()));
        name = bundle.getString(ROBOT_NAME_KEY, "");
        masterUriString = bundle.getString(MASTER_URI_KEY, "http://localhost:11311");
        joystickTopic = bundle.getString(JOYSTICK_TOPIC_KEY, "/pses_basis/commad");
        cameraTopic = bundle.getString(CAMERA_TOPIC_KEY, "/kinect2/qhd/image_color/compressed");
        laserTopic = bundle.getString(LASER_SCAN_TOPIC_KEY, "/scan");
        odometryTopic = bundle.getString(ODOMETRY_TOPIC_KEY, "/odom");
        sensorDataTopic = bundle.getString(SENSOR_DATA_TOPIC_KEY, "/pses_basis/sensor_data");
        carInfoTopic = bundle.getString(CAR_INFO_TOPIC_KEY, "/pses_basis/car_info");
        enableKinect = bundle.getBoolean(ENABLE_KINECT_KEY, false);
        reverseLaserScan = bundle.getBoolean(REVERSE_LASER_SCAN_KEY, false);
        invertX = bundle.getBoolean(INVERT_X_KEY, false);
        invertY = bundle.getBoolean(INVERT_Y_KEY, false);
        invertAngularVelocity = bundle.getBoolean(INVERT_ANGULAR_VELOCITY_KEY, false);
    }

    public void load(@NonNull SharedPreferences prefs) {
        joystickTopic = prefs.getString(RobotStorage.getPreferenceKey(JOYSTICK_TOPIC_KEY), "/pses_basis/commad");
        cameraTopic = prefs.getString(RobotStorage.getPreferenceKey(CAMERA_TOPIC_KEY), "/kinect2/qhd/image_color/compressed");
        laserTopic = prefs.getString(RobotStorage.getPreferenceKey(LASER_SCAN_TOPIC_KEY), "/scan");
        odometryTopic = prefs.getString(RobotStorage.getPreferenceKey(ODOMETRY_TOPIC_KEY), "/odom");
        sensorDataTopic = prefs.getString(RobotStorage.getPreferenceKey(SENSOR_DATA_TOPIC_KEY), "/pses_basis/sensor_data");
        carInfoTopic = prefs.getString(RobotStorage.getPreferenceKey(CAR_INFO_TOPIC_KEY), "/pses_basis/car_info");
        enableKinect = prefs.getBoolean(RobotStorage.getPreferenceKey(ENABLE_KINECT_KEY), false);
        reverseLaserScan = prefs.getBoolean(RobotStorage.getPreferenceKey(REVERSE_LASER_SCAN_KEY), false);
        invertX = prefs.getBoolean(RobotStorage.getPreferenceKey(INVERT_X_KEY), false);
        invertY = prefs.getBoolean(RobotStorage.getPreferenceKey(INVERT_Y_KEY), false);
        invertAngularVelocity = prefs.getBoolean(RobotStorage.getPreferenceKey(INVERT_ANGULAR_VELOCITY_KEY), false);
    }

    @Override
    public void save(@NonNull Bundle bundle) {
        bundle.putString(UUID_KEY, id.toString());
        bundle.putString(ROBOT_NAME_KEY, name);
        bundle.putString(MASTER_URI_KEY, masterUriString);
        bundle.putString(JOYSTICK_TOPIC_KEY, joystickTopic);
        bundle.putString(CAMERA_TOPIC_KEY, cameraTopic);
        bundle.putString(LASER_SCAN_TOPIC_KEY, laserTopic);
        bundle.putString(ODOMETRY_TOPIC_KEY, odometryTopic);
        bundle.putString(SENSOR_DATA_TOPIC_KEY, sensorDataTopic);
        bundle.putString(CAR_INFO_TOPIC_KEY, carInfoTopic);
        bundle.putBoolean(ENABLE_KINECT_KEY, enableKinect);
        bundle.putBoolean(REVERSE_LASER_SCAN_KEY, reverseLaserScan);
        bundle.putBoolean(INVERT_X_KEY, invertX);
        bundle.putBoolean(INVERT_Y_KEY, invertY);
        bundle.putBoolean(INVERT_ANGULAR_VELOCITY_KEY, invertAngularVelocity);
    }

    public void save(@NonNull SharedPreferences.Editor prefs) {
        prefs.putString(RobotStorage.getPreferenceKey(JOYSTICK_TOPIC_KEY), joystickTopic);
        prefs.putString(RobotStorage.getPreferenceKey(CAMERA_TOPIC_KEY), cameraTopic);
        prefs.putString(RobotStorage.getPreferenceKey(LASER_SCAN_TOPIC_KEY), laserTopic);
        prefs.putString(RobotStorage.getPreferenceKey(ODOMETRY_TOPIC_KEY), odometryTopic);
        prefs.putString(RobotStorage.getPreferenceKey(SENSOR_DATA_TOPIC_KEY), sensorDataTopic);
        prefs.putString(RobotStorage.getPreferenceKey(CAR_INFO_TOPIC_KEY), carInfoTopic);
        prefs.putBoolean(RobotStorage.getPreferenceKey(ENABLE_KINECT_KEY), enableKinect);
        prefs.putBoolean(RobotStorage.getPreferenceKey(REVERSE_LASER_SCAN_KEY), reverseLaserScan);
        prefs.putBoolean(RobotStorage.getPreferenceKey(INVERT_X_KEY), invertX);
        prefs.putBoolean(RobotStorage.getPreferenceKey(INVERT_Y_KEY), invertY);
        prefs.putBoolean(RobotStorage.getPreferenceKey(INVERT_ANGULAR_VELOCITY_KEY), invertAngularVelocity);
    }
}
