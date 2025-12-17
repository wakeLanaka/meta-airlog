FILESEXTRAPATHS:prepend := "${THISDIR}/wpa-supplicant:"

SRC_URI += " \
    file://wpa_supplicant.conf-sane \
"

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant

    mv ${D}${sysconfdir}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
}

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlan0.service"
