SUMMARY = "My custom image for the airlog project."

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL:append = " \
    qtbase \
    qtdeclarative \
    qtwayland \
    airlog \
    i2c-tools \
    wayland \
    weston \
    weston-init \
"

IMAGE_LINGUAS = ""
