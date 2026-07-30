package com.example.mealplannerkmp

import platform.UIKit.UIDevice
import platform.Foundation.NSString

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()