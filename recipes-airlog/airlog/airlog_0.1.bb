SUMMARY = "AirLog - Air Quality Monitoring System"
DESCRIPTION = "Layer to measure co2, ppm and humidity"
LICENSE = "CLOSED"

PV = "1.0"


SRC_URI ="git://github.com/wakeLanaka/code-airlog.git;protocol=https;branch=main \
           file://airlog.service \
"

           
SRCREV = "main"

S = "${WORKDIR}/git"

IMAGE_INSTALL:append = " \
    airlog \
    libgpiod \
    libgpiod-tools \
"

inherit pkgconfig qt6-cmake systemd
PACKAGECONFIG ??= ""
PACKAGECONFIG[test] = "-DBUILD_TESTING=ON,-DBUILD_TESTING=OFF,googletest"

OECMAKE_TARGET = "all"
EXTRA_OECMAKE = ""
SYSTEMD_SERVICE:${PN} = "airlog.service"

DEPENDS += " \
    libgpiod \
    qtbase \
    qtdeclarative \
    wayland \
    wayland-protocols \
    qtdeclarative-native \
    qtsensors \
"

RDEPENDS:${PN} += " \
    libgpiod \
    qtwayland \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/airlog.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "${localstatedir}/lib/airlog"
