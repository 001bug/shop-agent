package com.ohmygod.shopagent.manage.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频素材生产流水线的动态配置快照。
 *
 * <p>任务创建时应持久化一份配置快照，避免运行期间的配置调整影响已投递任务。</p>
 */
@Data
public class SystemConfigSnapshot {

    private IngestionOptions ingestion = new IngestionOptions();

    private VideoUnderstandingOptions understanding = new VideoUnderstandingOptions();

    private SegmentationOptions segmentation = new SegmentationOptions();

    private MaterialQualityOptions quality = new MaterialQualityOptions();

    private VideoRagOptions videoRag = new VideoRagOptions();

    private EditingAgentOptions editingAgent = new EditingAgentOptions();

    private RenderOptions render = new RenderOptions();

    private ReviewOptions review = new ReviewOptions();

    private TaskExecutionOptions execution = new TaskExecutionOptions();

    public static SystemConfigSnapshot defaults() {
        SystemConfigSnapshot snapshot = new SystemConfigSnapshot();
        snapshot.getSegmentation().setRules(new ArrayList<>(List.of(
            new SegmentRule("HOOK", "产品露脸或痛点引入", 0, 3),
            new SegmentRule("PAIN_POINT", "痛点引入", 3, 8),
            new SegmentRule("FEATURE", "功能展示", 8, 15),
            new SegmentRule("SCENARIO", "使用场景", 15, 22),
            new SegmentRule("CTA", "优惠或下单引导", 22, 28)
        )));
        return snapshot;
    }

    @Data
    public static class IngestionOptions {
        private int importPageSize = 1_000;
        private int downloadConcurrency = 8;
        private int maxDownloadRetries = 3;
        private int downloadTimeoutSeconds = 300;
        private long maxVideoSizeBytes = 500L * 1024 * 1024;
        private List<String> supportedFormats = new ArrayList<>(List.of("mp4", "mov", "avi", "mkv"));

        // MinIO 连接凭据由 application.yml 或环境变量管理，不存入动态快照。
        private String sourceBucket = "shop-agent-video";
        private String sourceObjectPrefix = "video/source";
        private String segmentObjectPrefix = "video/segment";
        private String renderObjectPrefix = "video/render";
    }

    @Data
    public static class VideoUnderstandingOptions {
        private boolean asrEnabled = true;
        private boolean ocrEnabled = true;
        private boolean visionEnabled = true;
        private boolean videoModelEnabled = true;

        // 可动态更换模型；模型 API Key 不应保存到该快照。
        private String asrModel = "whisper-large-v3";
        private String ocrModel = "paddle-ocr";
        private String visionModel = "qwen-vl-max";
        private String videoModel = "qwen-video-understanding";

        private int frameSampleIntervalSeconds = 1;
        private int sceneDetectThreshold = 30;
        private int modelTimeoutSeconds = 180;
        private int maxRetries = 2;
    }

    @Data
    public static class SegmentationOptions {
        private int minSegmentDurationSeconds = 2;
        private int maxSegmentDurationSeconds = 15;
        private boolean allowOverlappingSegments = false;
        private List<SegmentRule> rules = new ArrayList<>();
    }

    @Data
    public static class SegmentRule {
        private String segmentType;
        private String description;
        private int expectedStartSecond;
        private int expectedEndSecond;

        public SegmentRule() {
        }

        public SegmentRule(String segmentType, String description, int expectedStartSecond, int expectedEndSecond) {
            this.segmentType = segmentType;
            this.description = description;
            this.expectedStartSecond = expectedStartSecond;
            this.expectedEndSecond = expectedEndSecond;
        }
    }

    @Data
    public static class MaterialQualityOptions {
        private int sMinScore = 90;
        private int aMinScore = 75;
        private int bMinScore = 60;
        private double gmvWeight = 0.35D;
        private double ctrWeight = 0.20D;
        private double conversionWeight = 0.25D;
        private double visualQualityWeight = 0.20D;
        private int minRetrievableQualityScore = 60;
    }

    @Data
    public static class VideoRagOptions {
        private String embeddingModel = "text-embedding-v3";
        private int embeddingBatchSize = 64;
        private int topK = 30;
        private int rerankTopK = 10;
        private double minSimilarity = 0.55D;
        private boolean filterByProductId = true;
        private boolean filterByMaterialGrade = true;
        private List<String> allowedGrades = new ArrayList<>(List.of("S", "A", "B"));
    }

    @Data
    public static class EditingAgentOptions {
        private boolean enabled = true;
        private String model = "qwen-plus";
        private double temperature = 0.2D;
        private int maxCandidatesPerSegmentType = 5;
        private List<String> preferredStructure = new ArrayList<>(
            List.of("HOOK", "PRODUCT", "FEATURE", "EVIDENCE", "CTA"));
    }

    @Data
    public static class RenderOptions {
        private String ffmpegPath = "ffmpeg";
        private String defaultAspectRatio = "9:16";
        private String defaultResolution = "1080x1920";
        private int defaultFps = 30;
        private int defaultVideoBitrateKbps = 4_000;
        private int defaultAudioBitrateKbps = 128;
        private boolean subtitleEnabled = true;
        private boolean bgmEnabled = true;
        private int batchSize = 10;
        private int renderTimeoutMinutes = 20;
    }

    @Data
    public static class ReviewOptions {
        private boolean manualReviewRequired = true;
        private boolean blockLowQualityMaterial = true;
        private int minFinalQualityScore = 70;
        private boolean checkCopyrightRisk = true;
        private boolean checkSensitiveContent = true;
    }

    @Data
    public static class TaskExecutionOptions {
        private int downloadWorkerConcurrency = 12;
        private int understandingWorkerConcurrency = 8;
        private int segmentationWorkerConcurrency = 8;
        private int renderingWorkerConcurrency = 4;
        private int maxRetryCount = 3;
        private int retryBackoffSeconds = 30;
    }
}
