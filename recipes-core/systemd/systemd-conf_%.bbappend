FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://25-wlan.network"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} += "wpa_supplicant@wlan0.service"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/25-wlan.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/25-wlan.network \
"
