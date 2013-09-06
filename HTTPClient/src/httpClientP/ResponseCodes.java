package httpClientP;

public enum ResponseCodes {
        OK(0),
        MISSING_PARAMETER(1001),
        INVALID_MSISDN(1002),
        AUTHENTICATION_FAILED(1004);

        int errorCode;

        private ResponseCodes (int errorCode) {
                this.errorCode = errorCode;
        }

        public int value() {
                return this.errorCode;
        }

}